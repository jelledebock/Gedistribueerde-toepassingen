using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

using BadmintonInterface;

namespace BadmintonLibraryService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IService1
    {
        [OperationContract]
        IList<BadmintonLibraryService.SportClub> getBadmintonClubs();

        [OperationContract]
        IList<BadmintonLibraryService.Lid> getMembers(int id);

    }

    // Use a data contract as illustrated in the sample below to add composite types to service operations.
    // You can add XSD files into the project. After building the project, you can directly use the data types defined there, with the namespace "BadmintonLibraryService.ContractType".
    [DataContract]
    public class SportClub
    {
        public SportClub(BadmintonInterface.SportClub club)
        {
            this.Naam = club.Naam;
            this.Tornooien = new List<Tornooi>();
            foreach(BadmintonInterface.Tornooi tornooi in club.Tornooien)
            {
                this.Tornooien.Add(new BadmintonLibraryService.Tornooi(tornooi));
            }
        }
        [DataMember]
        public string Naam { get; set; }
        [DataMember]
        public List<Tornooi> Tornooien { get; set; }

    }

    [DataContract]
    public class Tornooi
    {
        public Tornooi(BadmintonInterface.Tornooi tornooi)
        {
            this.ID = tornooi.ID;
            this.Naam = tornooi.Naam;         
        }
        [DataMember]
        public int ID { get; set; }
        [DataMember]
        public string Naam { get; set; }
    }


    [DataContract]
    public class Lid
    {
        public Lid(BadmintonInterface.Lid lid)
        {
            this.ID = lid.ID;
            this.Naam = lid.Naam;
        }
        [DataMember]
        public int ID { get; set; }
        [DataMember]
        public string Naam { get; set; }
    }
}
