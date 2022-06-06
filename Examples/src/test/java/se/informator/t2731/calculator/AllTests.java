package se.informator.t2731.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestSimpleCalculatorAdd.class,
			TestSimpleCalculatorSub.class,
			TestSimpleCalculatorMult.class,
			TestSimpleCalculatorDiv.class				
		}

)
public class AllTests {;}

