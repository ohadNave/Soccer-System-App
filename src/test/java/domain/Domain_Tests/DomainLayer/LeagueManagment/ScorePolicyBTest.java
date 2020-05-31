package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.IScorePolicy;
import com.example.DB_Tests.DomainLayer.LeagueManagment.ScorePolicyB;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScorePolicyBTest {
    IScorePolicy scorePolicy= new ScorePolicyB();
    @Test
    public void execute() {
        scorePolicy.execute(null,true,null,null);
    }
}