package edu.stanford.epad.common.pixelmed;

import java.util.HashMap;
import java.util.Map;

import com.pixelmed.anatproc.CodedConcept;

import edu.stanford.epad.common.util.EPADLogger;

public class SegmentedPropertyHelper {
	
	class SegmentedProperty {
		CodedConcept category;
		CodedConcept type;
		CodedConcept modifier;
		String defColor;
		SegmentedProperty(String c,String t,String m, String defColor) {
			
			this.category=str2cc(c);
			this.type=str2cc(t);
			this.modifier=str2cc(m);
			this.defColor=defColor;
		}
		
	}
	
	CodedConcept str2cc(String s){
		if (s==null)
			return null;
		//input (T-D000A;SRT;Anatomical Structure)
		s=s.replace("(", "").replace(")", "");
		String[] str=s.split(";");
		return new CodedConcept(null /* conceptUniqueIdentifier */, null /* SNOMED CID */,
				str[1] /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
				null /* codingSchemeVersion */, str[0] /* codeValue */, str[2] /* codeMeaning */,
				null /* codeStringEquivalent */, null /* synonynms */);

	}
	static Map<Integer,SegmentedProperty> properties=new HashMap<Integer,SegmentedProperty>();
	
	SegmentedPropertyHelper() {
		if (properties.isEmpty()) {
			properties.put(1,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-D0050;SRT;Tissue)",null,"rgb(128;174;128)"));
			properties.put(2,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-D016E;SRT;Bone)",null,"rgb(241;214;145)"));
			properties.put(3,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-01000;SRT;Skin)",null,"rgb(177;122;101)"));
			properties.put(4,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-1A200;SRT;Connective Tissue)",null,"rgb(111;184;210)"));
			properties.put(5,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-C2000;SRT;Blood)",null,"rgb(216;101;79)"));
			properties.put(6,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-1A310;SRT;Organ)",null,"rgb(221;130;101)"));
			properties.put(7,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-03000;SRT;Mass)",null,"rgb(144;238;144)"));
			properties.put(8,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-13001;SRT;Muscle)",null,"rgb(192;104;88)"));
			properties.put(9,new SegmentedProperty("(A-00004;SRT;Physical Object)","(M-30400;SRT;Foreign Body)",null,"rgb(220;245;20)"));
			properties.put(10,new SegmentedProperty("(A-00004;SRT;Physical Object)","(F-61779;SRT;Waste Material)",null,"rgb(78;63;0)"));
			properties.put(11,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-5401E;SRT;Tooth)",null,"rgb(255;250;220)"));
			properties.put(12,new SegmentedProperty("(T-D0050;SRT;Tissue)","(F-03D38;SRT;Body Fat)",null,"rgb(230;220;70)"));
			properties.put(13,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-A0096;SRT;Gray Matter)",null,"rgb(200;200;235)"));
			properties.put(14,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-A0095;SRT;White Matter)",null,"rgb(250;250;210)"));
			properties.put(15,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-D0598;SRT;Nerve)",null,"rgb(244;214;49)"));
			properties.put(16,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-4806E;SRT;Vein)",null,"rgb(0;151;206)"));
			properties.put(17,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-41066;SRT;Artery)",null,"rgb(216;101;79)"));
			properties.put(18,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-40050;SRT;Capillary)",null,"rgb(183;156;220)"));
			properties.put(19,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-18010;SRT;Ligament)",null,"rgb(183;214;211)"));
			properties.put(20,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-17010;SRT;Tendon)",null,"rgb(152;189;207)"));
			properties.put(21,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-D021B;SRT;Cartilage)",null,"rgb(111;184;210)"));
			properties.put(22,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-15009;SRT;Meniscus)",null,"rgb(178;212;242)"));
			properties.put(23,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-C4000;SRT;Lymph Node)",null,"rgb(68;172;100)"));
			properties.put(24,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-C6010;SRT;Lymphatic Vessel)",null,"rgb(111;197;131)"));
			properties.put(25,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-A1000;SRT;Cerebrospinal Fluid)",null,"rgb(85;188;255)"));
			properties.put(26,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-60650;SRT;Bile)",null,"rgb(0;145;30)"));
			properties.put(27,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-70060;SRT;Urine)",null,"rgb(214;230;130)"));
			properties.put(28,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-59666;SRT;Feces)",null,"rgb(78;63;0)"));
			properties.put(29,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(C-10080;SRT;Gas)",null,"rgb(218;255;255)"));
			properties.put(30,new SegmentedProperty("(T-D0080;SRT;Body Substance)","(T-D0070;SRT;Body Fluid)",null,"rgb(170;250;250)"));
			properties.put(31,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-36300;SRT;Edema)",null,"rgb(140;224;228)"));
			properties.put(32,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-37000;SRT;Hemorrhage)",null,"rgb(188;65;28)"));
			properties.put(33,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-54000;SRT;Necrosis)",null,"rgb(216;191;216)"));
			properties.put(34,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-35000;SRT;Blood Clot)",null,"rgb(145;60;66)"));
			properties.put(35,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-35300;SRT;Embolus)",null,"rgb(150;98;83)"));
			properties.put(36,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D1105;SRT;Head)",null,"rgb(177;122;101)"));
			properties.put(37,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0091;SRT;Central Nervous System)",null,"rgb(244;214;49)"));
			properties.put(38,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0100;SRT;Brain)",null,"rgb(250;250;225)"));
			properties.put(39,new SegmentedProperty("(T-D0050;SRT;Tissue)","(T-A2020;SRT;Cerebral Gray Matter)",null,"rgb(200;200;215)"));
			properties.put(40,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A010E;SRT;Telencephalon)",null,"rgb(68;131;98)"));
			properties.put(41,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2021;SRT;Cerebral Cortex)",null,"rgb(128;174;128)"));
			properties.put(42,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2218;SRT;Frontal Lobe)","(G-A100;SRT;Right)","rgb(83;146;164)"));
			properties.put(43,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2218;SRT;Frontal Lobe)","(G-A101;SRT;Left)","rgb(83;146;164)"));
			properties.put(44,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2513;SRT;Temporal Lobe)","(G-A100;SRT;Right)","rgb(162;115;105)"));
			properties.put(45,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2513;SRT;Temporal Lobe)","(G-A101;SRT;Left)","rgb(162;115;105)"));
			properties.put(46,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A230F;SRT;Parietal Lobe)","(G-A100;SRT;Right)","rgb(141;93;137)"));
			properties.put(47,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A230F;SRT;Parietal Lobe)","(G-A101;SRT;Left)","rgb(141;93;137)"));
			properties.put(48,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A240F;SRT;Occipital Lobe)","(G-A100;SRT;Right)","rgb(182;166;110)"));
			properties.put(49,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A240F;SRT;Occipital Lobe)","(G-A101;SRT;Left)","rgb(182;166;110)"));
			properties.put(50,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2615;SRT;Insula)","(G-A100;SRT;Right)","rgb(188;135;166)"));
			properties.put(51,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2615;SRT;Insula)","(G-A101;SRT;Left)","rgb(188;135;166)"));
			properties.put(52,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0036;SRT;Limbic Lobe)","(G-A100;SRT;Right)","rgb(154;150;201)"));
			properties.put(53,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0036;SRT;Limbic Lobe)","(G-A101;SRT;Left)","rgb(154;150;201)"));
			properties.put(54,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3101;SRT;Corpus Striatum)","(G-A100;SRT;Right)","rgb(177;140;190)"));
			properties.put(55,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3101;SRT;Corpus Striatum)","(G-A101;SRT;Left)","rgb(177;140;190)"));
			properties.put(56,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3201;SRT;Caudate Nucleus)","(G-A100;SRT;Right)","rgb(30;111;85)"));
			properties.put(57,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3201;SRT;Caudate Nucleus)","(G-A101;SRT;Left)","rgb(30;111;85)"));
			properties.put(58,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3401;SRT;Putamen)","(G-A100;SRT;Right)","rgb(210;157;166)"));
			properties.put(59,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3401;SRT;Putamen)","(G-A101;SRT;Left)","rgb(210;157;166)"));
			properties.put(60,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3503;SRT;Globus Pallidus)","(G-A100;SRT;Right)","rgb(48;129;126)"));
			properties.put(61,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3503;SRT;Globus Pallidus)","(G-A101;SRT;Left)","rgb(48;129;126)"));
			properties.put(62,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3231;SRT;Amygdaloid Nucleus)","(G-A100;SRT;Right)","rgb(98;153;112)"));
			properties.put(63,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A3231;SRT;Amygdaloid Nucleus)","(G-A101;SRT;Left)","rgb(98;153;112)"));
			properties.put(64,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0107;SRT;Diencephalon)","(G-A100;SRT;Right)","rgb(69;110;53)"));
			properties.put(65,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A4001;SRT;Nucleus of Thalamus)","(G-A101;SRT;Left)","rgb(166;113;137)"));
			properties.put(66,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A4001;SRT;Nucleus of Thalamus)","(G-A100;SRT;Right)","rgb(122;101;38)"));
			properties.put(67,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A4001;SRT;Nucleus of Thalamus)","(G-A101;SRT;Left)","rgb(122;101;38)"));
			properties.put(68,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B2003;SRT;Pineal Gland)",null,"rgb(253;135;192)"));
			properties.put(69,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A510A;SRT;Midbrain)",null,"rgb(145;92;109)"));
			properties.put(70,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A5163;SRT;Substantia Nigra)",null,"rgb(46;101;131)"));
			properties.put(71,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A5163;SRT;Substantia Nigra)","(G-A100;SRT;Right)","rgb(0;108;112)"));
			properties.put(72,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A5163;SRT;Substantia Nigra)","(G-A101;SRT;Left)","rgb(0;108;112)"));
			properties.put(73,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2032;SRT;Cerebral White Matter)",null,"rgb(250;250;225)"));
			properties.put(74,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2820;SRT;Superior Longitudinal Fasciculus)","(G-A100;SRT;Right)","rgb(127;150;88)"));
			properties.put(75,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2820;SRT;Superior Longitudinal Fasciculus)","(G-A101;SRT;Left)","rgb(127;150;88)"));
			properties.put(76,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2851;SRT;Inferior Longitudinal Fasciculus)","(G-A100;SRT;Right)","rgb(159;116;163)"));
			properties.put(77,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2851;SRT;Inferior Longitudinal Fasciculus)","(G-A101;SRT;Left)","rgb(159;116;163)"));
			properties.put(78,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(276650;FMA;Arcuate Fasciculus)","(G-A100;SRT;Right)","rgb(125;102;154)"));
			properties.put(79,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(276650;FMA;Arcuate Fasciculus)","(G-A101;SRT;Left)","rgb(125;102;154)"));
			properties.put(80,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2831;SRT;Uncinate Fasciculus)","(G-A100;SRT;Right)","rgb(106;174;155)"));
			properties.put(81,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2831;SRT;Uncinate Fasciculus)","(G-A101;SRT;Left)","rgb(106;174;155)"));
			properties.put(82,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2841;SRT;Cingulum)","(G-A100;SRT;Right)","rgb(154;146;83)"));
			properties.put(83,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2841;SRT;Cingulum)","(G-A101;SRT;Left)","rgb(154;146;83)"));
			properties.put(85,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A709C;SRT;Lateral Corticospinal Tract)","(G-A100;SRT;Right)","rgb(201;160;133)"));
			properties.put(86,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A709C;SRT;Lateral Corticospinal Tract)","(G-A101;SRT;Left)","rgb(201;160;133)"));
			properties.put(87,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2881;SRT;Optic Radiation)","(G-A100;SRT;Right)","rgb(78;152;141)"));
			properties.put(88,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2881;SRT;Optic Radiation)","(G-A101;SRT;Left)","rgb(78;152;141)"));
			properties.put(89,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A5273; SRT;Medial Lemniscus)","(G-A100;SRT;Right)","rgb(174;140;103)"));
			properties.put(90,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A5273; SRT;Medial Lemniscus)","(G-A101;SRT;Left)","rgb(174;140;103)"));
			properties.put(91,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6621; SRT; superior cerebellar peduncle)","(G-A100;SRT;Right)","rgb(139;126;177)"));
			properties.put(92,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6621; SRT; superior cerebellar peduncle)","(G-A101;SRT;Left)","rgb(139;126;177)"));
			properties.put(93,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6631;SRT;middle cerebellar peduncle)","(G-A100;SRT;Right)","rgb(148;120;72)"));
			properties.put(94,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6631;SRT;middle cerebellar peduncle)","(G-A101;SRT;Left)","rgb(148;120;72)"));
			properties.put(95,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6641;SRT;inferior cerebellar peduncle )","(G-A100;SRT;Right)","rgb(186;135;135)"));
			properties.put(96,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6641;SRT;inferior cerebellar peduncle )","(G-A101;SRT;Left)","rgb(186;135;135)"));
			properties.put(97,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A800B;SRT;Optic Chiasm)",null,"rgb(99;106;24)"));
			properties.put(98,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A807B1;SRT;optic tract)","(G-A100;SRT;Right)","rgb(156;171;108)"));
			properties.put(99,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A807B1;SRT;optic tract)","(G-A101;SRT;Left)","rgb(156;171;108)"));
			properties.put(100,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2978;SRT;cerebral fornix)","(G-A100;SRT;Right)","rgb(64;123;147)"));
			properties.put(101,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2978;SRT;cerebral fornix)","(G-A101;SRT;Left)","rgb(64;123;147)"));
			properties.put(103,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A2701;SRT;corpus callosum)",null,"rgb(97;113;158)"));
			properties.put(104,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A4904;SRT;Posterior Cerebral Commissure)",null,"rgb(126;161;197)"));
			properties.put(105,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A6080;SRT;Cerebellar White Matter)",null,"rgb(194;195;164)"));
			properties.put(106,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0109;SRT;Brain Cerebrospinal Fluid Pathway)",null,"rgb(85;188;255)"));
			properties.put(107,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1603;SRT;Ventricle of Brain)",null,"rgb(88;106;215)"));
			properties.put(108,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1651;SRT;lateral ventricle)","(G-A100;SRT;Right)","rgb(88;106;215)"));
			properties.put(109,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1651;SRT;lateral ventricle)","(G-A101;SRT;Left)","rgb(88;106;215)"));
			properties.put(110,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1741;SRT;third ventricle)","(G-A100;SRT;Right)","rgb(88;106;215)"));
			properties.put(111,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1741;SRT;third ventricle)","(G-A101;SRT;Left)","rgb(88;106;215)"));
			properties.put(112,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0106;SRT;cerebral aqueduct)",null,"rgb(88;106;215)"));
			properties.put(113,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1821;SRT;fourth ventricle)",null,"rgb(88;106;215)"));
			properties.put(114,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1503;SRT;subarachnoid space)",null,"rgb(88;106;215)"));
			properties.put(115,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A7013;SRT;spinal cord)",null,"rgb(244;214;49)"));
			properties.put(116,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A7020;SRT;Spinal Cord Gray Matter)",null,"rgb(200;200;215)"));
			properties.put(117,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A7070;SRT;Spinal Cord White Matter)",null,"rgb(250;250;225)"));
			properties.put(119,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B0007;SRT;pituitary gland)",null,"rgb(57;157;110)"));
			properties.put(120,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B1101;SRT;adenohypophysis)",null,"rgb(60;143;83)"));
			properties.put(121,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B1201;SRT;neurohypophysis)",null,"rgb(92;162;109)"));
			properties.put(122,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1110;SRT;Meninges)",null,"rgb(255;244;209)"));
			properties.put(123,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1121;SRT;dura mater)",null,"rgb(255;244;209)"));
			properties.put(124,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1223;SRT;arachnoid)",null,"rgb(255;244;209)"));
			properties.put(125,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A1283;SRT;pia mater)",null,"rgb(255;244;209)"));
			properties.put(126,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-13103;SRT;Entire skeletal muscle of head)",null,"rgb(201;121;77)"));
			properties.put(127,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-61004;SRT;salivary gland)",null,"rgb(70;163;117)"));
			properties.put(128,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-52004;SRT;lip)",null,"rgb(188;91;95)"));
			properties.put(129,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-21003;SRT;nose)",null,"rgb(177;122;101)"));
			properties.put(130,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-5300D;SRT;tongue)",null,"rgb(166;84;94)"));
			properties.put(131,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-51127;SRT;soft palate)",null,"rgb(182;105;107)"));
			properties.put(132,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB707;SRT;inner ear )","(G-A100;SRT;Right)","rgb(229;147;118)"));
			properties.put(133,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB707;SRT;inner ear )","(G-A101;SRT;Left)","rgb(229;147;118)"));
			properties.put(134,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB10B;SRT;external ear )","(G-A100;SRT;Right)","rgb(174;122;90)"));
			properties.put(135,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB10B;SRT;external ear )","(G-A101;SRT;Left)","rgb(174;122;90)"));
			properties.put(136,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB306;SRT;middle ear)","(G-A100;SRT;Right)","rgb(201;112;73)"));
			properties.put(137,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AB306;SRT;middle ear)","(G-A101;SRT;Left)","rgb(201;112;73)"));
			properties.put(138,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AA636;SRT;Fundus of Eye)","(G-A100;SRT;Right)","rgb(194;142;0)"));
			properties.put(139,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-AA636;SRT;Fundus of Eye)","(G-A101;SRT;Left)","rgb(194;142;0)"));
			properties.put(140,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-11100;SRT;Skull)",null,"rgb(241;213;144)"));
			properties.put(141,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C6;SRT;frontal bone)","(G-A100;SRT;Right)","rgb(203;179;77)"));
			properties.put(142,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C6;SRT;frontal bone)","(G-A101;SRT;Left)","rgb(203;179;77)"));
			properties.put(143,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C7;SRT;parietal bone )","(G-A100;SRT;Right)","rgb(229;204;109)"));
			properties.put(144,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C7;SRT;parietal bone )","(G-A101;SRT;Left)","rgb(229;204;109)"));
			properties.put(145,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C8;SRT;temporal bone)","(G-A100;SRT;Right)","rgb(255;243;152)"));
			properties.put(146,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C8;SRT;temporal bone)","(G-A101;SRT;Left)","rgb(255;243;152)"));
			properties.put(147,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111B9;SRT;sphenoid bone)","(G-A100;SRT;Right)","rgb(209;185;85)"));
			properties.put(148,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111B9;SRT;sphenoid bone)","(G-A101;SRT;Left)","rgb(209;185;85)"));
			properties.put(149,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111B7;SRT;ethmoid bone)","(G-A100;SRT;Right)","rgb(248;223;131)"));
			properties.put(150,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111B7;SRT;ethmoid bone)","(G-A101;SRT;Left)","rgb(248;223;131)"));
			properties.put(151,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111C9;SRT;occipital bone )",null,"rgb(255;230;138)"));
			properties.put(152,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111D4;SRT;maxilla)",null,"rgb(196;172;68)"));
			properties.put(153,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111BE;SRT;zygoma)","(G-A100;SRT;Right)","rgb(255;255;167)"));
			properties.put(154,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111B8;SRT;lacrimal bone) ","(G-A100;SRT;Right)","rgb(255;250;160)"));
			properties.put(155,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-21349;SRT;vomer bone)",null,"rgb(255;237;145)"));
			properties.put(156,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111A8;SRT;palatine bone) ","(G-A100;SRT;Right)","rgb(242;217;123)"));
			properties.put(157,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111A8;SRT;palatine bone) ","(G-A101;SRT;Left)","rgb(242;217;123)"));
			properties.put(158,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111D3;SRT;mandible )",null,"rgb(222;198;101)"));
			properties.put(159,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D1607;SRT;neck )",null,"rgb(177;122;101)"));
			properties.put(160,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-13311;SRT;skeletal muscle of neck)",null,"rgb(213;124;109)"));
			properties.put(161,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-55002;SRT;pharynx )",null,"rgb(184;105;108)"));
			properties.put(162,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-2410C;SRT;larynx)",null,"rgb(150;208;243)"));
			properties.put(163,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B0004;SRT;thyroid gland )",null,"rgb(62;162;114)"));
			properties.put(164,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B0006;SRT;parathyroid gland )","(G-A100;SRT;Right)","rgb(62;162;114)"));
			properties.put(165,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B0006;SRT;parathyroid gland )","(G-A101;SRT;Left)","rgb(62;162;114)"));
			properties.put(166,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D006D;SRT;bone structure of head and/or neck)",null,"rgb(242;206;142)"));
			properties.put(167,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-111BF;SRT;hyoid bone)",null,"rgb(250;210;139)"));
			properties.put(168,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-116E0;SRT;Entire cervical vertebra)",null,"rgb(255;255;207)"));
			properties.put(169,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D3003;SRT;thorax)",null,"rgb(177;122;101)"));
			properties.put(170,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-2500A;SRT;trachea)",null,"rgb(182;228;255)"));
			properties.put(171,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-26000;SRT;Bronchi)",null,"rgb(175;216;244)"));
			properties.put(172,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28000;SRT;Lung)","(G-A100;SRT;Right)","rgb(197;165;145)"));
			properties.put(173,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28000;SRT;Lung)","(G-A101;SRT;Left)","rgb(197;165;145)"));
			properties.put(174,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28821;SRT;Upper Lobe of Lung)","(G-A100;SRT;Right)","rgb(172;138;115)"));
			properties.put(175,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28821;SRT;Upper Lobe of Lung)","(G-A101;SRT;Left)","rgb(172;138;115)"));
			properties.put(176,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28301;SRT;MIddle Lobe of Right Lung)",null,"rgb(202;164;140)"));
			properties.put(177,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28831;SRT;Lower Lobe of Lung)","(G-A100;SRT;Right)","rgb(224;186;162)"));
			properties.put(178,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-28831;SRT;Lower Lobe of Lung)","(G-A101;SRT;Left)","rgb(224;186;162)"));
			properties.put(179,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-29001;SRT;pleura)",null,"rgb(255;245;217)"));
			properties.put(180,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32000;SRT;Heart)",null,"rgb(206;110;84)"));
			properties.put(181,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32101;SRT;atrium)",null,"rgb(210;115;89)"));
			properties.put(182,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32101;SRT;atrium)",null,"rgb(203;108;81)"));
			properties.put(183,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32158;SRT;interatrial septum)",null,"rgb(233;138;112)"));
			properties.put(184,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-3241C;SRT;interventricular septum)",null,"rgb(195;100;73)"));
			properties.put(185,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32500;SRT;Right Ventricle)",null,"rgb(181;85;57)"));
			properties.put(186,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-32600;SRT;Left Ventricle)",null,"rgb(152;55;13)"));
			properties.put(187,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-35301;SRT;mitral valve)",null,"rgb(159;63;27)"));
			properties.put(188,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-35102;SRT;tricuspid valve)",null,"rgb(166;70;38)"));
			properties.put(189,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-35401;SRT;aortic valve)",null,"rgb(218;123;97)"));
			properties.put(190,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-35201;SRT;pulmonary valve)",null,"rgb(225;130;104)"));
			properties.put(191,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-42000;SRT;Aorta)",null,"rgb(224;97;76)"));
			properties.put(192,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-39004;SRT;pericardium)",null,"rgb(255;244;209)"));
			properties.put(193,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-39051;SRT;pericardial cavity)",null,"rgb(184;122;154)"));
			properties.put(194,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-56000;SRT;Esophagus)",null,"rgb(211;171;143)"));
			properties.put(195,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-C8000;SRT;Thymus Gland)",null,"rgb(47;150;103)"));
			properties.put(196,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D3300;SRT;Mediastinum)",null,"rgb(255;244;209)"));
			properties.put(197,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-0243C;SRT;skin of chest)",null,"rgb(173;121;88)"));
			properties.put(198,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-14104;SRT;skeletal muscle of thorax)",null,"rgb(188;95;76)"));
			properties.put(199,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-110E9;SRT;bone organ of thorax)",null,"rgb(255;239;172)"));
			properties.put(200,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-1171F;SRT;thoracic vertebral column)",null,"rgb(226;202;134)"));
			properties.put(201,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-11300;SRT;Rib)",null,"rgb(253;232;158)"));
			properties.put(202,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-11210;SRT;Sternum)",null,"rgb(244;217;154)"));
			properties.put(203,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-12310;SRT;Clavicle)","(G-A100;SRT;Right)","rgb(205;179;108)"));
			properties.put(204,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-12310;SRT;Clavicle)","(G-A101;SRT;Left)","rgb(205;179;108)"));
			properties.put(205,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D401A;SRT;abdominal cavity)",null,"rgb(186;124;161)"));
			properties.put(206,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4000;SRT;Abdomen)",null,"rgb(177;122;101)"));
			properties.put(207,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4403;SRT;peritoneum)",null,"rgb(255;255;220)"));
			properties.put(208,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4601;SRT;omentum)",null,"rgb(234;234;194)"));
			properties.put(209,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4447;SRT;peritoneal cavity)",null,"rgb(204;142;178)"));
			properties.put(210,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4902;SRT;retroperitoneal space)",null,"rgb(180;119;153)"));
			properties.put(211,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-57001;SRT;stomach)",null,"rgb(216;132;105)"));
			properties.put(212,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-58206;SRT;duodenum)",null,"rgb(255;253;229)"));
			properties.put(213,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4033;SRT;Small Intestine)",null,"rgb(205;167;142)"));
			properties.put(214,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-59302;SRT;Colon)",null,"rgb(204;168;143)"));
			properties.put(215,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-59902;SRT;Anus)",null,"rgb(255;224;199)"));
			properties.put(216,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-62000;SRT;Liver)",null,"rgb(221;130;101)"));
			properties.put(217,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-60613;SRT;Bile Duct)",null,"rgb(0;145;30)"));
			properties.put(218,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-63002;SRT;gallbladder)",null,"rgb(139;150;98)"));
			properties.put(219,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D4034;SRT;pancreas)",null,"rgb(249;180;111)"));
			properties.put(220,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-C3000;SRT;Spleen)",null,"rgb(157;108;162)"));
			properties.put(221,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-70002;SRT;urinary system)",null,"rgb(203;136;116)"));
			properties.put(222,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-71000;SRT;Kidney)","(G-A100;SRT;Right)","rgb(185;102;83)"));
			properties.put(223,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-71000;SRT;Kidney)","(G-A101;SRT;Left)","rgb(185;102;83)"));
			properties.put(224,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-73005;SRT;ureter)",null,"rgb(247;182;164)"));
			properties.put(225,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-73005;SRT;ureter)",null,"rgb(247;182;164)"));
			properties.put(226,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-74000;SRT;Bladder)",null,"rgb(222;154;132)"));
			properties.put(227,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-75001;SRT;urethra )",null,"rgb(124;186;223)"));
			properties.put(228,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B3000;SRT;Adrenal Gland)","(G-A100;SRT;Right)","rgb(249;186;150)"));
			properties.put(229,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-B3000;SRT;Adrenal Gland)","(G-A101;SRT;Left)","rgb(249;186;150)"));
			properties.put(230,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-80021;SRT;female internal genitalia)",null,"rgb(244;170;147)"));
			properties.put(231,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-83000;SRT;Uterus)",null,"rgb(255;181;158)"));
			properties.put(232,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D6101;SRT;fallopian tube)",null,"rgb(255;190;165)"));
			properties.put(233,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D6101;SRT;fallopian tube)",null,"rgb(227;153;130)"));
			properties.put(234,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-87000;SRT;Ovary)","(G-A100;SRT;Right)","rgb(213;141;113)"));
			properties.put(235,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-87000;SRT;Ovary)","(G-A101;SRT;Left)","rgb(213;141;113)"));
			properties.put(236,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-82003;SRT;vagina)",null,"rgb(193;123;103)"));
			properties.put(237,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-90021;SRT;male internal genitalia)",null,"rgb(216;146;127)"));
			properties.put(238,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-92000;SRT;Prostate)",null,"rgb(230;158;140)"));
			properties.put(239,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-93000;SRT;Seminal Vesicle)","(G-A100;SRT;Right)","rgb(245;172;147)"));
			properties.put(240,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-93000;SRT;Seminal Vesicle)","(G-A101;SRT;Left)","rgb(245;172;147)"));
			properties.put(241,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-96004;SRT;Vas Deferens)","(G-A100;SRT;Right)","rgb(241;172;151)"));
			properties.put(242,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-96004;SRT;Vas Deferens)","(G-A101;SRT;Left)","rgb(241;172;151)"));
			properties.put(243,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-02489;SRT;Entire skin of abdomen)",null,"rgb(177;124;92)"));
			properties.put(244,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-14205;SRT;Entire abdominal wall muscle)",null,"rgb(171;85;68)"));
			properties.put(246,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-1190E;SRT;lumbar vertebral column)",null,"rgb(212;188;102)"));
			properties.put(247,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-80011;SRT;female external genitalia)",null,"rgb(185;135;134)"));
			properties.put(248,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-90012;SRT;Entire male external genitalia )",null,"rgb(185;135;134)"));
			properties.put(249,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-124A6;SRT;Entire bone of upper extremity)",null,"rgb(198;175;125)"));
			properties.put(250,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-1360E;SRT;Entire skeletal muscle of upper limb)",null,"rgb(194;98;79)"));
			properties.put(251,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8004;SRT;upper limb)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(252,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8004;SRT;upper limb)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(253,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D067C;SRT;shoulder region)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(254,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D067C;SRT;shoulder region)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(255,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D820B;SRT;upper arm)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(256,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D820B;SRT;upper arm)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(257,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D06CA;SRT;elbow)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(258,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D06CA;SRT;elbow)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(259,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8508;SRT;forearm)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(260,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8508;SRT;forearm)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(261,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D0787;SRT;wrist region)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(262,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D0787;SRT;wrist region)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(263,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8701;SRT;hand)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(264,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D8701;SRT;hand)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(265,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-127BF;SRT;Entire bone of lower extremity)",null,"rgb(255;238;170)"));
			properties.put(266,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-1466E;SRT;Entire skeletal muscle of lower limb)",null,"rgb(206;111;93)"));
			properties.put(267,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D903B;SRT;lower limb)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(268,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D903B;SRT;lower limb)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(269,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D2503;SRT;hip region)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(270,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D2503;SRT;hip region)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(271,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D9106;SRT;thigh)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(272,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D9106;SRT;thigh)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(273,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D03BA;SRT;knee region)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(274,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D03BA;SRT;knee region)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(275,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D940B;SRT;lower leg from knee to ankle)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(276,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D940B;SRT;lower leg from knee to ankle)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(277,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D9706;SRT;foot)","(G-A100;SRT;Right)","rgb(177;122;101)"));
			properties.put(278,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-D9706;SRT;foot)","(G-A101;SRT;Left)","rgb(177;122;101)"));
			properties.put(279,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A0141;SRT;peripheral nervous system)",null,"rgb(216;186;0)"));
			properties.put(280,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A9606;SRT;autonomic nerve)",null,"rgb(255;226;77)"));
			properties.put(281,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A9637;SRT;sympathetic trunk)",null,"rgb(255;243;106)"));
			properties.put(282,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A800A;SRT;cranial nerve)",null,"rgb(255;234;92)"));
			properties.put(283,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A8008;SRT;vagus nerve)",null,"rgb(240;210;35)"));
			properties.put(284,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-A051B;SRT;peripheral nerve)",null,"rgb(224;194;0)"));
			properties.put(285,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-30001;SRT;Cardiovascular system)",null,"rgb(213;99;79)"));
			properties.put(286,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-4105E;SRT;Systemic arterial structure)",null,"rgb(217;102;81)"));
			properties.put(287,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-4000B;SRT;Entire systemic vein)",null,"rgb(0;147;202)"));
			properties.put(288,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-44012;SRT;Entire pulmonary artery)",null,"rgb(0;122;171)"));
			properties.put(289,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-48500;SRT;Entire pulmonary vein)",null,"rgb(186;77;64)"));
			properties.put(290,new SegmentedProperty("(T-D000A;SRT;Anatomical Structure)","(T-C6004;SRT;lymphatic system)",null,"rgb(111;197;131)"));
			properties.put(291,new SegmentedProperty("(A-00004;SRT;Physical Object)","(A-30360;SRT;Needle)",null,"rgb(240;255;30)"));
			properties.put(309,new SegmentedProperty("(M-01000;SRT;Morphologically Altered Structure)","(M-3340A;SRT;Cyst)",null,"rgb(205;205;100)"));


		}
	}
	
	SegmentedProperty getSegmentProperty(String idStr) {

		if (idStr == null){
			return properties.get(1);
		}
		int id=0;
		try{
			id=Integer.parseInt(idStr);
		}catch(NumberFormatException ne){
			return properties.get(1);
		}
		
		if (properties.get(id) == null){
			return properties.get(1);
		}
		return properties.get(id);
		
	}
	
}
