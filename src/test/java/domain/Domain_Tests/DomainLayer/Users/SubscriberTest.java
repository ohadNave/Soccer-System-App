package domain.Domain_Tests.DomainLayer.Users;

import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.CoachRole;
import com.example.DB_Tests.DomainLayer.Enums.RefereeRoll;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriberTest {
    String userName= "user";
    String password ="1234";
    String name = "shlomi";
    Subscriber subscriber;
    @Before
    public void initialize(){
        subscriber= MyFactory.createSubscriber(userName,password,name);

    }
    @Test
    public void testAll(){
        getId();
        getName();
        setName();
        getUserName();
        setUserName();
        getPassword();
        setPassword();
        isActive();
        setActive();
        makeCoachNotActive();
        makeCoachActive();
        getCoach();
        makeFanActive();
        makeFanNotActive();
        getFan();
        getReferee();

    }


   // @Test
    public void getName() {
        assertEquals(subscriber.getName(),name);
    }

  //  @Test
    public void setName() {
        subscriber.setName("Dana");
        assertEquals(subscriber.getName(),"Dana");
    }

 //   @Test
    public void getId() {
        Subscriber subscriber1= MyFactory.createSubscriber(userName,password,name);
        Subscriber subscriber2= MyFactory.createSubscriber(userName,password,name);
        assertEquals(subscriber1.getId(),subscriber2.getId()-1);
    }

 //   @Test
    public void getUserName() {
        assertEquals(subscriber.getUserName(),userName);
    }

 //   @Test
    public void setUserName() {
        subscriber.setUserName("new userName");
        assertEquals(subscriber.getUserName(),"new userName");
    }

 //   @Test
    public void getPassword() {
        assertEquals(subscriber.getPassword(),password);
    }

 //   @Test
    public void setPassword() {
        subscriber.setPassword("4321");
        assertEquals(subscriber.getPassword(),"4321");
    }

 //   @Test
    public void isActive() {
        assertFalse(subscriber.isActive());
        subscriber.setActive(true);
        assertTrue(subscriber.isActive());
    }

  //  @Test
    public void setActive() {
        subscriber.setActive(false);
        assertFalse(subscriber.isActive());
        subscriber.setActive(true);
        assertTrue(subscriber.isActive());
    }

  //  @Test
    public void makeCoachActive() {
        //check if role is null
        assertFalse(subscriber.makeCoachActive(null, Certification.BASIC));

        //check if certification is null
        assertFalse(  subscriber.makeCoachActive(CoachRole.AttackerCoach, null));

        //check if everything is OK
        assertTrue(subscriber.makeCoachActive(CoachRole.AttackerCoach, Certification.BASIC));
        subscriber.makeCoachNotActive();
    }

  //  @Test
    public void makeCoachNotActive() {
        //in case coach is null
        assertFalse(subscriber.makeCoachNotActive());

        //in case everything is OK
        assertTrue(subscriber.makeCoachActive(CoachRole.AttackerCoach,Certification.BASIC));
        assertTrue(subscriber.makeCoachNotActive());
        assertNull(subscriber.getCoach());
        subscriber.makeCoachNotActive();
    }

 //   @Test
    public void getCoach() {
        //n case there is no coach
        subscriber.makeCoachNotActive();
        assertNull(subscriber.getCoach());

        //in case there is coach
        assertTrue(subscriber.makeCoachActive(CoachRole.AttackerCoach,  Certification.BASIC));
        assertNotNull(subscriber.getCoach());
        subscriber.makeCoachNotActive();
    }

  //  @Test
    public void makeFanActive() {
        //check if everything is OK
        assertTrue(subscriber.makeFanActive());

        //check if Fan is not null
        assertFalse(subscriber.makeFanActive());
        subscriber.makeFanNotActive();

    }

  //  @Test
    public void makeFanNotActive() {
        //in case fan is null
        assertFalse(subscriber.makeFanNotActive());

        //in case everything is OK
        assertTrue(subscriber.makeFanActive());
        assertTrue(subscriber.makeFanNotActive());
        assertNull(subscriber.getFan());
        subscriber.makeFanNotActive();
    }

   // @Test
    public void getFan() {
        //n case there is no Fan
        assertNull(subscriber.getFan());

        //in case there is Fan
        assertTrue(subscriber.makeFanActive());
        assertNotNull(subscriber.getFan());
        subscriber.makeFanNotActive();
    }

    @Test
    public void makeRefereeNotActive() {
        //in case LineReferre is null
        assertFalse(subscriber.makeRefereeNotActive());

        //in case everything is OK
        assertTrue(subscriber.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE));
        assertTrue(subscriber.makeRefereeNotActive());
        assertNull(subscriber.getReferee());
        subscriber.makeRefereeNotActive();
    }

  //  @Test
    public void getReferee() {
        //n case there is no LineReferre
        assertNull(subscriber.getReferee());

        //in case there is LineReferre
        assertTrue(subscriber.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE));
        assertNotNull(subscriber.getReferee());
        subscriber.makeRefereeNotActive();
    }

  //  @Test
    public void makeRefereeActive() {
        //check if everything is OK
        assertTrue(subscriber.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE));

        //check if MainReferee is not null
        assertFalse(subscriber.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE));
        subscriber.makeRefereeNotActive();
    }

//  //  @Test
//    public void makeRefereeNotActive() {
//        //in case MainReferee is null
//        assertFalse(subscriber.makeRefereeNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makeRefereeActive(Certification.BASIC));
//        assertTrue(subscriber.makeRefereeNotActive());
//        assertNull(subscriber.getRefefree());
//        subscriber.makeRefereeNotActive();
//    }
//
//  //  @Test
//    public void getMainReferee() {
//        //n case there is no MainReferee
//        assertNull(subscriber.getMainReferee());
//
//        //in case there is MainReferee
//        assertTrue(subscriber.makeRefereeActive(Certification.BASIC));
//        assertNotNull(subscriber.getMainReferee());
//        subscriber.makeRefereeNotActive();
//    }
//
//   // @Test
//    public void makePlayerActive() {
//        //check if everything is OK
//        assertTrue(subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(12,2,22)));
//        assertNotNull(DBManagerStub.getPlayer(subscriber.getId()));
//
//        //check if Player is not null
//        assertFalse(subscriber.makePlayerActive(playerRole.ATTACKER,LocalDate.of(12,2,22)));
//        subscriber.makePlayerNotActive();
//    }
//
//   // @Test
//    public void makePlayerNotActive() {
//        //in case Player is null
//        assertFalse(subscriber.makePlayerNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(12,2,22)));
//        assertTrue(subscriber.makePlayerNotActive());
//        assertNull(subscriber.getPlayer());
//        subscriber.makePlayerNotActive();
//    }
//
//   // @Test
//    public void getPlayer() {
//        //n case there is no Player
//        assertNull(subscriber.getPlayer());
//
//        //in case there is Player
//        assertTrue(subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(12,2,22)));
//        assertNotNull(subscriber.getPlayer());
//        subscriber.makePlayerNotActive();
//    }
//
// //   @Test
//    public void makeTeamManagerActive() {
//        //check if everything is OK
//        assertTrue(subscriber.makeTeamManagerActive());
//        assertNotNull(DBManagerStub.getTeamManager(subscriber.getId()));
//
//        //check if TeamManager is not null
//        assertFalse(subscriber.makeTeamManagerActive());
//        subscriber.makeTeamManagerNotActive();
//    }
//
//  //  @Test
//    public void makeTeamManagerNotActive() {
//        //in case TeamManager is null
//        assertFalse(subscriber.makeTeamManagerNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makeTeamManagerActive());
//        assertTrue(subscriber.makeTeamManagerNotActive());
//        assertNull(subscriber.getTeamManager());
//        subscriber.makeTeamManagerNotActive();
//    }
//
//  //  @Test
//    public void getTeamManager() {
//        //n case there is no TeamManager
//        assertNull(subscriber.getTeamManager());
//
//        //in case there is TeamManager
//        assertTrue(subscriber.makeTeamManagerActive());
//        assertNotNull(subscriber.getTeamManager());
//        subscriber.makeTeamManagerNotActive();
//    }
//
//   // @Test
//    public void makeOwnerActive() {
//        //check if everything is OK
//        assertTrue(subscriber.makeOwnerActive());
//        assertNotNull(DBManagerStub.getOwner(subscriber.getId()));
//
//        //check if Owner is not null
//        assertFalse(subscriber.makeOwnerActive());
//        subscriber.makeOwnerNotActive();
//    }
//
//  //  @Test
//    public void makeOwnerNotActive() {
//        //in case Owner is null
//        assertFalse(subscriber.makeOwnerNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makeOwnerActive());
//        assertTrue(subscriber.makeOwnerNotActive());
//        assertNull(subscriber.getOwner());
//        subscriber.makeOwnerNotActive();
//    }
//
//  //  @Test
//    public void getOwner() {
//        //n case there is no Owner
//        assertNull(subscriber.getOwner());
//
//        //in case there is Owner
//        assertTrue(subscriber.makeOwnerActive());
//        assertNotNull(subscriber.getOwner());
//        subscriber.makeOwnerNotActive();
//    }
//
//  //  @Test
//    public void makeFARActive() {
//        //check if everything is OK
//        assertTrue(subscriber.makeFARActive());
//        assertNotNull(DBManagerStub.getFAR(subscriber.getId()));
//
//        //check if FAR is not null
//        assertFalse(subscriber.makeFARActive());
//        subscriber.makeFarNotActive();
//    }
//
//  // @Test
//    public void makeFarNotActive() {
//        //in case FAR is null
//        assertFalse(subscriber.makeFarNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makeFARActive());
//        assertTrue(subscriber.makeFarNotActive());
//        assertNull(subscriber.getFAR());
//        subscriber.makeFarNotActive();
//    }
//
//  //  @Test
//    public void getFAR() {
//        //n case there is no FAR
//        assertNull(subscriber.getFAR());
//
//        //in case there is FAR
//        assertTrue(subscriber.makeFARActive());
//        assertNotNull(subscriber.getFAR());
//        subscriber.makeFarNotActive();
//    }
//
//  //  @Test
//    public void makeSystemManagerActive() {
//        //check if everything is OK
//        assertTrue(subscriber.makeSystemManagerActive());
//        assertNotNull(DBManagerStub.getSystemManager(subscriber.getId()));
//
//        //check if SystemManager is not null
//        assertFalse(subscriber.makeSystemManagerActive());
//        subscriber.makeSystemManagerNotActive();
//    }
//
//   // @Test
//    public void makeSystemManagerNotActive() {
//        //in case SystemManager is null
//        assertFalse(subscriber.makeSystemManagerNotActive());
//
//        //in case everything is OK
//        assertTrue(subscriber.makeSystemManagerActive());
//        assertTrue(subscriber.makeSystemManagerNotActive());
//        assertNull(subscriber.getSystemManager());
//        subscriber.makeSystemManagerNotActive();
//    }
//
// //   @Test
//    public void getSystemManager() {
//        //n case there is no SystemManager
//        assertNull(subscriber.getSystemManager());
//
//        //in case there is SystemManager
//        assertTrue(subscriber.makeSystemManagerActive());
//        assertNotNull(subscriber.getSystemManager());
//        subscriber.makeSystemManagerNotActive();
//    }
//
//  //  @Test
//    public void makeMainRefereeRequest() {
//        //check if systemManager is null
//
//
//        //check if systemManager is not null
//
//    }
//
//   // @Test
//    public void makeLineRefereeRequest() {
//    }
//
////    @Test
//    public void makeTeamManagerRequest() {
//    }
//
// //   @Test
//    public void makePlayerRequest() {
//    }
//
// //   @Test
//    public void makeCoachRequest() {
//    }
//
//  //  @Test
//    public void makeOwnerRequest() {
//    }
}