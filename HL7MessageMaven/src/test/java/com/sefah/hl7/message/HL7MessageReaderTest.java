package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


public class HL7MessageReaderTest {
	
	final String HL7_MESSAGE_ORU_R01 =  "MSH|^~\\&|mas|MY XXXX LAB|mas|100|201303201430||ORU^R01||P|2.3|\r" + 
			"PID|1|K2TE154871^^Hallo|^^^MRN~^^^CID~^^^ACCN|234567892|K2^TEST^||19640512|M|||^^FL^|||||U|||||||0||\r" + 
			"ORC|1|000133423|||CM||||201206132103|PHH|201206141230|^^^^^^^^^|||||261^XXXX CARE CENTER|31231 IN.STATE ROAD 17 SUITE 102^LAUDERHILL^NY^22313^95455848444|3|PHH|\r" + 
			"IN1|1|09102|MCARE|MEDICARE PART B|PO BOX 44117^^JACKSONVILLE^FL^322310018||8664549007||MEDICARE PART B|||||||K2^TEST^|01|00000000|^^NY^||||||||||||||||||||||||||||T|\r" + 
			"DG1|1|ICD|319|UNSPECIFIED MENTAL RETARDATION|||||||||||||BUIR154337^000039106|\r" + 
			"DG2|1|ICD|30490|UNSPECIFIED DRUG DEPENDENCE, UNSPECIFIED USE|||||||||||||HOJA159610^000039110|\r" + 
			"OBR|1|234567892||22014^K2S|||201211151512|201211151514||||||201211151512||^^^^^^^^^||A|GENERAL CHEMISTRY||||||X|\r" + 
			"OBX|1|TX|22014^K2S|  ^A^A|X||-||||X||9|201211150000||...||\r" + 
			"OBR|2|234567892||2521S^K2S|||201211151512|201211181214|||A|||201211151512||^^^^^^^^^||D|DRUGS||||||F|\r" + 
			"OBX|1|TX|2521S^K2S|  ^A^A|NEGATIVE|CUTOFF 20 ng/ml|-||||F||9|201211181214||MAM||\r" + 
			"OBR|3|234567892||4814^GABA|||201211151512|201212061207|||A|||201211151512||^^^^^^^^^||D|DRUGS||||||C|\r" + 
			"OBX|1|TX|4814^GABA|  ^D^D|X||-||||X||9|201212060949||RBJ|MERCY^^^^^^|\r" + 
			"NTE|1|LD|A THERAPEUTIC RANGE FOR GABAPENTIN HAS NOT BEEN ESTABLISHED. THE RANGE OF|\r" + 
			"NTE|2|LD|THE ASSAY IS 0.75 TO 40.00 ug/mL.REPORTABLE RESULT BELOW THIS RANGE IS|\r" + 
			"NTE|3|LD|<0.75 ug/mL AND ABOVE THIS RANGE IS >40.0 ug/ml.|\r" + 
			"OBR|4|234567892||9632^GABA|||201211151512|201211191214|||A|||201211151512||^^^^^^^^^||A|GENERAL CHEMISTRY||||||X|\r" + 
			"OBX|1|TX|9632^GABA|  ^A^A|X|ng/ml|NEGATIVE-|*|||X||9|201211191214||MAM||";
	
	final String HL7_MESSAGE_ORU_R01_SIMPLE = "MSH|^~\\&|mas|MY XXXX LAB|mas|100|201303201430||ORU^R01||P|2.3|\r" + 
			"PID|1|K2TE154871^^Hallo|^^^MRN~^^^CID~^^^ACCN|234567892|K2^TEST^||19640512|M|||^^FL^|||||U|||||||0||";

	@Test
	public void testHL7_MESSAGE_ORU_R01() throws Exception {
		final HL7Message message = new HL7Message(HL7_MESSAGE_ORU_R01);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),17);
	}
	
	@Test
	public void testHL7_MESSAGE_ORU_R01_SIMPLE() throws Exception {
		final HL7Message message = new HL7Message(HL7_MESSAGE_ORU_R01_SIMPLE);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),2);
	}
}
