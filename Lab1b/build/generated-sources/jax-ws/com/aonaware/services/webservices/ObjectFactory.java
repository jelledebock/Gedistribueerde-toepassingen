
package com.aonaware.services.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aonaware.services.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfStrategy_QNAME = new QName("http://services.aonaware.com/webservices/", "ArrayOfStrategy");
    private final static QName _String_QNAME = new QName("http://services.aonaware.com/webservices/", "string");
    private final static QName _WordDefinition_QNAME = new QName("http://services.aonaware.com/webservices/", "WordDefinition");
    private final static QName _ArrayOfDictionaryWord_QNAME = new QName("http://services.aonaware.com/webservices/", "ArrayOfDictionaryWord");
    private final static QName _ArrayOfDictionary_QNAME = new QName("http://services.aonaware.com/webservices/", "ArrayOfDictionary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aonaware.services.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DefineInDict }
     * 
     */
    public DefineInDict createDefineInDict() {
        return new DefineInDict();
    }

    /**
     * Create an instance of {@link StrategyListResponse }
     * 
     */
    public StrategyListResponse createStrategyListResponse() {
        return new StrategyListResponse();
    }

    /**
     * Create an instance of {@link ArrayOfStrategy }
     * 
     */
    public ArrayOfStrategy createArrayOfStrategy() {
        return new ArrayOfStrategy();
    }

    /**
     * Create an instance of {@link DictionaryListExtended }
     * 
     */
    public DictionaryListExtended createDictionaryListExtended() {
        return new DictionaryListExtended();
    }

    /**
     * Create an instance of {@link ServerInfo }
     * 
     */
    public ServerInfo createServerInfo() {
        return new ServerInfo();
    }

    /**
     * Create an instance of {@link WordDefinition }
     * 
     */
    public WordDefinition createWordDefinition() {
        return new WordDefinition();
    }

    /**
     * Create an instance of {@link DefineResponse }
     * 
     */
    public DefineResponse createDefineResponse() {
        return new DefineResponse();
    }

    /**
     * Create an instance of {@link MatchInDictResponse }
     * 
     */
    public MatchInDictResponse createMatchInDictResponse() {
        return new MatchInDictResponse();
    }

    /**
     * Create an instance of {@link ArrayOfDictionaryWord }
     * 
     */
    public ArrayOfDictionaryWord createArrayOfDictionaryWord() {
        return new ArrayOfDictionaryWord();
    }

    /**
     * Create an instance of {@link ArrayOfDictionary }
     * 
     */
    public ArrayOfDictionary createArrayOfDictionary() {
        return new ArrayOfDictionary();
    }

    /**
     * Create an instance of {@link DictionaryList }
     * 
     */
    public DictionaryList createDictionaryList() {
        return new DictionaryList();
    }

    /**
     * Create an instance of {@link Match }
     * 
     */
    public Match createMatch() {
        return new Match();
    }

    /**
     * Create an instance of {@link DictionaryListResponse }
     * 
     */
    public DictionaryListResponse createDictionaryListResponse() {
        return new DictionaryListResponse();
    }

    /**
     * Create an instance of {@link Define }
     * 
     */
    public Define createDefine() {
        return new Define();
    }

    /**
     * Create an instance of {@link DefineInDictResponse }
     * 
     */
    public DefineInDictResponse createDefineInDictResponse() {
        return new DefineInDictResponse();
    }

    /**
     * Create an instance of {@link MatchResponse }
     * 
     */
    public MatchResponse createMatchResponse() {
        return new MatchResponse();
    }

    /**
     * Create an instance of {@link StrategyList }
     * 
     */
    public StrategyList createStrategyList() {
        return new StrategyList();
    }

    /**
     * Create an instance of {@link DictionaryInfo }
     * 
     */
    public DictionaryInfo createDictionaryInfo() {
        return new DictionaryInfo();
    }

    /**
     * Create an instance of {@link DictionaryInfoResponse }
     * 
     */
    public DictionaryInfoResponse createDictionaryInfoResponse() {
        return new DictionaryInfoResponse();
    }

    /**
     * Create an instance of {@link MatchInDict }
     * 
     */
    public MatchInDict createMatchInDict() {
        return new MatchInDict();
    }

    /**
     * Create an instance of {@link ServerInfoResponse }
     * 
     */
    public ServerInfoResponse createServerInfoResponse() {
        return new ServerInfoResponse();
    }

    /**
     * Create an instance of {@link DictionaryListExtendedResponse }
     * 
     */
    public DictionaryListExtendedResponse createDictionaryListExtendedResponse() {
        return new DictionaryListExtendedResponse();
    }

    /**
     * Create an instance of {@link Dictionary }
     * 
     */
    public Dictionary createDictionary() {
        return new Dictionary();
    }

    /**
     * Create an instance of {@link Definition }
     * 
     */
    public Definition createDefinition() {
        return new Definition();
    }

    /**
     * Create an instance of {@link Strategy }
     * 
     */
    public Strategy createStrategy() {
        return new Strategy();
    }

    /**
     * Create an instance of {@link ArrayOfDefinition }
     * 
     */
    public ArrayOfDefinition createArrayOfDefinition() {
        return new ArrayOfDefinition();
    }

    /**
     * Create an instance of {@link DictionaryWord }
     * 
     */
    public DictionaryWord createDictionaryWord() {
        return new DictionaryWord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStrategy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aonaware.com/webservices/", name = "ArrayOfStrategy")
    public JAXBElement<ArrayOfStrategy> createArrayOfStrategy(ArrayOfStrategy value) {
        return new JAXBElement<ArrayOfStrategy>(_ArrayOfStrategy_QNAME, ArrayOfStrategy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aonaware.com/webservices/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WordDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aonaware.com/webservices/", name = "WordDefinition")
    public JAXBElement<WordDefinition> createWordDefinition(WordDefinition value) {
        return new JAXBElement<WordDefinition>(_WordDefinition_QNAME, WordDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDictionaryWord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aonaware.com/webservices/", name = "ArrayOfDictionaryWord")
    public JAXBElement<ArrayOfDictionaryWord> createArrayOfDictionaryWord(ArrayOfDictionaryWord value) {
        return new JAXBElement<ArrayOfDictionaryWord>(_ArrayOfDictionaryWord_QNAME, ArrayOfDictionaryWord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDictionary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aonaware.com/webservices/", name = "ArrayOfDictionary")
    public JAXBElement<ArrayOfDictionary> createArrayOfDictionary(ArrayOfDictionary value) {
        return new JAXBElement<ArrayOfDictionary>(_ArrayOfDictionary_QNAME, ArrayOfDictionary.class, null, value);
    }

}
