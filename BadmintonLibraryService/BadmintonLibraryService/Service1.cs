using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using BadmintonInterface;

namespace BadmintonLibraryService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in both code and config file together.
    public class Service1 : IService1
    {
        private BadmintonDAODummy badminton_dao;

        public Service1()
        {
            badminton_dao = new BadmintonDAODummy();
        }
        public IList<BadmintonLibraryService.SportClub> getBadmintonClubs()
        {
            List<BadmintonLibraryService.SportClub> clubs = new List<SportClub>();
            foreach (BadmintonInterface.SportClub club in badminton_dao.SportClubs)
            {
                clubs.Add(new BadmintonLibraryService.SportClub(club));
            }
            return clubs;
        }

        public IList<BadmintonLibraryService.Lid> getMembers(int id)
        {
            List<BadmintonLibraryService.Lid> leden = new List<Lid>();
            foreach(BadmintonInterface.Lid lid in badminton_dao.GeefLeden(id)){
                leden.Add(new BadmintonLibraryService.Lid(lid));
            }
            return leden;
        }
    }
}
