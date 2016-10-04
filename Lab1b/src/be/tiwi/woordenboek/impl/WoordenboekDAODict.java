package be.tiwi.woordenboek.impl;
import be.tiwi.woordenboek.data.Woordenboek;
import be.tiwi.woordenboek.data.WoordenboekDAO;
import com.aonaware.services.webservices.ArrayOfDefinition;
import com.aonaware.services.webservices.ArrayOfDictionaryWord;
import com.aonaware.services.webservices.Definition;
import com.aonaware.services.webservices.DictService;
import com.aonaware.services.webservices.DictServiceSoap;
import com.aonaware.services.webservices.Dictionary;
import com.aonaware.services.webservices.DictionaryWord;
import com.aonaware.services.webservices.WordDefinition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelle De Bock
 */
public class WoordenboekDAODict implements WoordenboekDAO{
    private DictService service;
    private DictServiceSoap soap_service;
    
    public WoordenboekDAODict() {
        this.service = new DictService();
        this.soap_service = service.getDictServiceSoap();
    }
    
    @Override
    public List<Woordenboek> getWoordenboeken() {
        List<Dictionary> list;
        list = soap_service.dictionaryList().getDictionary();
        
        List<Woordenboek> woordenboeken = new ArrayList<>();
        
        for(Dictionary dict : list){
            Woordenboek tmp = new Woordenboek(dict.getId(), dict.getName());
            
            woordenboeken.add(tmp);
        }
        return woordenboeken;
    }

    @Override
    public List<String> zoekWoorden(String prefix, String woordenboekId) {
        List<DictionaryWord> matchings = soap_service.matchInDict(woordenboekId, prefix, "prefix").getDictionaryWord();
        List<String> output = new ArrayList<>();
        
        for(DictionaryWord word : matchings){
            output.add(word.getWord().toUpperCase());
        }
        return output;
    }

    @Override
    public List<String> getDefinities(String woord, String woordenboekId) {
        WordDefinition dict = soap_service.defineInDict(woordenboekId, woord);
        List<Definition> definitions = dict.getDefinitions().getDefinition();
        List<String> returnval = new ArrayList<>();
        for(Definition def : definitions){
            String output = def.getWord().toUpperCase()+","+def.getWordDefinition();
            
            returnval.add(output);
        }
        
        return returnval;  
    }
    
}
