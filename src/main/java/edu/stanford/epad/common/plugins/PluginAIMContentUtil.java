/*******************************************************************************
 * Copyright (c) 2015 The Board of Trustees of the Leland Stanford Junior University
 * BY CLICKING ON "ACCEPT," DOWNLOADING, OR OTHERWISE USING EPAD, YOU AGREE TO THE FOLLOWING TERMS AND CONDITIONS:
 * STANFORD ACADEMIC SOFTWARE SOURCE CODE LICENSE FOR
 * "ePAD Annotation Platform for Radiology Images"
 *
 * This Agreement covers contributions to and downloads from the ePAD project ("ePAD") maintained by The Board of Trustees 
 * of the Leland Stanford Junior University ("Stanford"). 
 *
 * *	Part A applies to downloads of ePAD source code and/or data from ePAD. 
 *
 * *	Part B applies to contributions of software and/or data to ePAD (including making revisions of or additions to code 
 * and/or data already in ePAD), which may include source or object code. 
 *
 * Your download, copying, modifying, displaying, distributing or use of any ePAD software and/or data from ePAD 
 * (collectively, the "Software") is subject to Part A. Your contribution of software and/or data to ePAD (including any 
 * that occurred prior to the first publication of this Agreement) is a "Contribution" subject to Part B. Both Parts A and 
 * B shall be governed by and construed in accordance with the laws of the State of California without regard to principles 
 * of conflicts of law. Any legal action involving this Agreement or the Research Program will be adjudicated in the State 
 * of California. This Agreement shall supersede and replace any license terms that you may have agreed to previously with 
 * respect to ePAD.
 *
 * PART A. DOWNLOADING AGREEMENT - LICENSE FROM STANFORD WITH RIGHT TO SUBLICENSE ("SOFTWARE LICENSE").
 * 1. As used in this Software License, "you" means the individual downloading and/or using, reproducing, modifying, 
 * displaying and/or distributing Software and the institution or entity which employs or is otherwise affiliated with you. 
 * Stanford  hereby grants you, with right to sublicense, with respect to Stanford's rights in the Software, a 
 * royalty-free, non-exclusive license to use, reproduce, make derivative works of, display and distribute the Software, 
 * provided that: (a) you adhere to all of the terms and conditions of this Software License; (b) in connection with any 
 * copy, distribution of, or sublicense of all or any portion of the Software, the terms and conditions in this Software 
 * License shall appear in and shall apply to such copy and such sublicense, including without limitation all source and 
 * executable forms and on any user documentation, prefaced with the following words: "All or portions of this licensed 
 * product  have been obtained under license from The Board of Trustees of the Leland Stanford Junior University. and are 
 * subject to the following terms and conditions" AND any user interface to the Software or the "About" information display 
 * in the Software will display the following: "Powered by ePAD http://epad.stanford.edu;" (c) you preserve and maintain 
 * all applicable attributions, copyright notices and licenses included in or applicable to the Software; (d) modified 
 * versions of the Software must be clearly identified and marked as such, and must not be misrepresented as being the 
 * original Software; and (e) you consider making, but are under no obligation to make, the source code of any of your 
 * modifications to the Software freely available to others on an open source basis.
 *
 * 2. The license granted in this Software License includes without limitation the right to (i) incorporate the Software 
 * into your proprietary programs (subject to any restrictions applicable to such programs), (ii) add your own copyright 
 * statement to your modifications of the Software, and (iii) provide additional or different license terms and conditions 
 * in your sublicenses of modifications of the Software; provided that in each case your use, reproduction or distribution 
 * of such modifications otherwise complies with the conditions stated in this Software License.
 * 3. This Software License does not grant any rights with respect to third party software, except those rights that 
 * Stanford has been authorized by a third party to grant to you, and accordingly you are solely responsible for (i) 
 * obtaining any permissions from third parties that you need to use, reproduce, make derivative works of, display and 
 * distribute the Software, and (ii) informing your sublicensees, including without limitation your end-users, of their 
 * obligations to secure any such required permissions.
 * 4. You agree that you will use the Software in compliance with all applicable laws, policies and regulations including, 
 * but not limited to, those applicable to Personal Health Information ("PHI") and subject to the Institutional Review 
 * Board requirements of the your institution, if applicable. Licensee acknowledges and agrees that the Software is not 
 * FDA-approved, is intended only for research, and may not be used for clinical treatment purposes. Any commercialization 
 * of the Software is at the sole risk of you and the party or parties engaged in such commercialization. You further agree 
 * to use, reproduce, make derivative works of, display and distribute the Software in compliance with all applicable 
 * governmental laws, regulations and orders, including without limitation those relating to export and import control.
 * 5. You or your institution, as applicable, will indemnify, hold harmless, and defend Stanford against any third party 
 * claim of any kind made against Stanford arising out of or related to the exercise of any rights granted under this 
 * Agreement, the provision of Software, or the breach of this Agreement. Stanford provides the Software AS IS and WITH ALL 
 * FAULTS.  Stanford makes no representations and extends no warranties of any kind, either express or implied.  Among 
 * other things, Stanford disclaims any express or implied warranty in the Software:
 * (a)  of merchantability, of fitness for a particular purpose,
 * (b)  of non-infringement or 
 * (c)  arising out of any course of dealing.
 *
 * Title and copyright to the Program and any associated documentation shall at all times remain with Stanford, and 
 * Licensee agrees to preserve same. Stanford reserves the right to license the Program at any time for a fee.
 * 6. None of the names, logos or trademarks of Stanford or any of Stanford's affiliates or any of the Contributors, or any 
 * funding agency, may be used to endorse or promote products produced in whole or in part by operation of the Software or 
 * derived from or based on the Software without specific prior written permission from the applicable party.
 * 7. Any use, reproduction or distribution of the Software which is not in accordance with this Software License shall 
 * automatically revoke all rights granted to you under this Software License and render Paragraphs 1 and 2 of this 
 * Software License null and void.
 * 8. This Software License does not grant any rights in or to any intellectual property owned by Stanford or any 
 * Contributor except those rights expressly granted hereunder.
 *
 * PART B. CONTRIBUTION AGREEMENT - LICENSE TO STANFORD WITH RIGHT TO SUBLICENSE ("CONTRIBUTION AGREEMENT").
 * 1. As used in this Contribution Agreement, "you" means an individual providing a Contribution to ePAD and the 
 * institution or entity which employs or is otherwise affiliated with you.
 * 2. This Contribution Agreement applies to all Contributions made to ePAD at any time. By making a Contribution you 
 * represent that: (i) you are legally authorized and entitled by ownership or license to make such Contribution and to 
 * grant all licenses granted in this Contribution Agreement with respect to such Contribution; (ii) if your Contribution 
 * includes any patient data, all such data is de-identified in accordance with U.S. confidentiality and security laws and 
 * requirements, including but not limited to the Health Insurance Portability and Accountability Act (HIPAA) and its 
 * regulations, and your disclosure of such data for the purposes contemplated by this Agreement is properly authorized and 
 * in compliance with all applicable laws and regulations; and (iii) you have preserved in the Contribution all applicable 
 * attributions, copyright notices and licenses for any third party software or data included in the Contribution.
 * 3. Except for the licenses you grant in this Agreement, you reserve all right, title and interest in your Contribution.
 * 4. You hereby grant to Stanford, with the right to sublicense, a perpetual, worldwide, non-exclusive, no charge, 
 * royalty-free, irrevocable license to use, reproduce, make derivative works of, display and distribute the Contribution. 
 * If your Contribution is protected by patent, you hereby grant to Stanford, with the right to sublicense, a perpetual, 
 * worldwide, non-exclusive, no-charge, royalty-free, irrevocable license under your interest in patent rights embodied in 
 * the Contribution, to make, have made, use, sell and otherwise transfer your Contribution, alone or in combination with 
 * ePAD or otherwise.
 * 5. You acknowledge and agree that Stanford ham may incorporate your Contribution into ePAD and may make your 
 * Contribution as incorporated available to members of the public on an open source basis under terms substantially in 
 * accordance with the Software License set forth in Part A of this Agreement. You further acknowledge and agree that 
 * Stanford shall have no liability arising in connection with claims resulting from your breach of any of the terms of 
 * this Agreement.
 * 6. YOU WARRANT THAT TO THE BEST OF YOUR KNOWLEDGE YOUR CONTRIBUTION DOES NOT CONTAIN ANY CODE OBTAINED BY YOU UNDER AN 
 * OPEN SOURCE LICENSE THAT REQUIRES OR PRESCRIBES DISTRBUTION OF DERIVATIVE WORKS UNDER SUCH OPEN SOURCE LICENSE. (By way 
 * of non-limiting example, you will not contribute any code obtained by you under the GNU General Public License or other 
 * so-called "reciprocal" license.)
 *******************************************************************************/
package edu.stanford.epad.common.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim4api.base.AimException;
import edu.stanford.hakan.aim4api.base.ImageAnnotationCollection;
import edu.stanford.hakan.aim4api.base.TwoDimensionGeometricShapeEntity;
import edu.stanford.hakan.aim4api.plugin.PluginParameter;
import edu.stanford.hakan.aim4api.plugin.v4.PluginV4;
import edu.stanford.hakan.aim4api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim4api.usage.AnnotationGetter;

/**
 * TODO This text-based approach to extracting content from an AIM file is terrible and should be replaced.
 * <p>
 * It is used only by the TedSeg and JJJector plugins.
 */
public class PluginAIMContentUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static String getAimFileContents(File aimFile) throws AimException
	{
		if (aimFile.exists()) {
			StringBuilder sb = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new FileReader(aimFile));
				try {
					String line = null;
					while ((line = in.readLine()) != null) {
						sb.append(line);
						sb.append(System.getProperty("line.separator"));
					}
				} finally {
					in.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return sb.toString();
		} else {
			log.warning("AIM file " + aimFile.getAbsolutePath() + "does not exist");
			throw new AimException("input error - AIM.xml does not exist. file: " + aimFile.getAbsolutePath());
		}
	}
	
	public static List<PluginParameter> getPluginParametersFromFile(File aimFile,String pluginId) throws Exception {
		List<PluginParameter> parameters=null;
		ImageAnnotationCollection iac = null;
		try {
			iac = AnnotationGetter.getImageAnnotationCollectionFromFile(aimFile.getPath(),
					EPADConfig.xsdFilePathV4);
		} catch (Exception e) {

			throw new PluginServletException("Invalid input.", "Had: " + e.getMessage() + ". data:" + AnnotationBuilder.convertToString(iac));
		}
		for (PluginV4 p : iac.getImageAnnotation().getPluginCollection().getListPlugin()) {
	        log.info("Plugins "+p.getName());
	        
	        if (p.getName().equals(pluginId)) {
	        	parameters=p.getPluginParemeterCollection().getListPluginParameter();
	        }
	       
			
			
		}
		log.info("Parameters "+parameters);
		return parameters;
	}
	
	public static List<PluginParameter> getPluginParametersFromIAC(ImageAnnotationCollection iac,String pluginId) throws Exception {
		List<PluginParameter> parameters=null;
		
		for (PluginV4 p : iac.getImageAnnotation().getPluginCollection().getListPlugin()) {
	        log.info("Plugins "+p.getName());
	        
	        if (p.getName().equals(pluginId)) {
	        	parameters=p.getPluginParemeterCollection().getListPluginParameter();
	        }
	       
			
			
		}
		log.info("Parameters "+parameters);
		return parameters;
	}

	public static String getStudyUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Study", "instanceUID", aimFileContents);
	}

	public static String getSeriesUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Series", "instanceUID", aimFileContents);
	}

	public static String getSOPInstanceUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Image", "sopInstanceUID", aimFileContents);
	}

	public static String getSecondSeriesUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("<ImageSeries ", "instanceUID", aimFileContents, 2);
	}

	public static String getSecondSOPInstanceUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("<Image ", "sopInstanceUID", aimFileContents, 2);
	}

	/**
	 * Get shapes from an aim file
	 * 
	 * 
	 * @param aimFileContents String
	 * @return List<String> A list of shape xsi types 
	 * Possible values are TwoDimensionPolyline, TwoDimensionSpline, TwoDimensionMultiPoint, TwoDimensionPoint, TwoDimensionCircle, TwoDimensionEllipse 
	 * for two dimension
	 * @throws edu.stanford.epad.common.plugins.PluginServletException
	 */
	public static List<String> getShapesFromAimFile(File aimFile) throws Exception
	{
	
		List<String> shapeXsis=new ArrayList<>();
		ImageAnnotationCollection iac = null;
		try {
			iac = AnnotationGetter.getImageAnnotationCollectionFromFile(aimFile.getPath(),
					EPADConfig.xsdFilePathV4);
			for (TwoDimensionGeometricShapeEntity ge:iac.getImageAnnotations().get(0).getTwoDimensionShapes()){
				shapeXsis.add(ge.getXsiType());
			}
			return shapeXsis;
			
			
		} catch (Exception e) {

			throw new PluginServletException("Invalid input.", "Had: " + e.getMessage() + ". data:" + AnnotationBuilder.convertToString(iac));
		}
			
	}
	
	
	/**
	 * Check if aim has closed shape
	 * 
	 * 
	 * @param aimFileContents String
	 * @return boolean
	 * @throws edu.stanford.epad.common.plugins.PluginServletException
	 */
	public static boolean hasClosedShape(File aimFile) throws Exception
	{
		
		List<String> shapes=getShapesFromAimFile(aimFile);
		
		for (String ge:shapes){
			if (ge.equals("TwoDimensionPolyline") || ge.equals("TwoDimensionSpline") || ge.equals("TwoDimensionCircle")) {
				return true;
			}
            
		}
		return false;
			
	}
	
	
	
	/**
	 * This data comes from a AIM-Template.
	 * 
	 * Look for: <AnatomicEntity annotatorConfidence="0.0" cagridId="0" codeMeaning="Lung CT" codeValue="jjv-1"
	 * codingSchemeDesignator="JJV" label="Organ Type"/>
	 * 
	 * @param aimFileContents String
	 * @return String
	 * @throws edu.stanford.epad.common.plugins.PluginServletException
	 */
	public static String getOrganFromAimFile(File aimFile) throws Exception
	{
		String templateOrganValue = null;
		ImageAnnotationCollection iac = null;
		try {
			iac = AnnotationGetter.getImageAnnotationCollectionFromFile(aimFile.getPath(),
					EPADConfig.xsdFilePathV4);
			//ml not code system, it should be display name
			if (iac.getImageAnnotations().get(0).getImagingPhysicalEntityCollection().get(0).getListTypeCode().get(0).getDisplayName()==null || iac.getImageAnnotations().get(0).getImagingPhysicalEntityCollection().get(0).getListTypeCode().get(0).getDisplayName().getValue().isEmpty()) {
				templateOrganValue = iac.getImageAnnotations().get(0).getImagingPhysicalEntityCollection().get(0).getListTypeCode().get(0).getCodeSystem();
			} else {
				templateOrganValue = iac.getImageAnnotations().get(0).getImagingPhysicalEntityCollection().get(0).getListTypeCode().get(0).getDisplayName().getValue();
			}

		} catch (Exception e) {
					
			if (iac!=null){
//				log.warning("Invalid input. Had: " + e.getMessage() + ". data:" + AnnotationBuilder.convertToString(iac)+ ". Defaulting to lung",e);				
				//default template organ value = lung
				if (templateOrganValue==null){
					log.warning("No organ name in the aim file. Defaulting to lung");				
					templateOrganValue="lung";
				}
			}else {
				throw new PluginServletException("Invalid input.", "Had: " + e.getMessage() + ". data:" + AnnotationBuilder.convertToString(iac));
			}
		}
				
		log.info("organ name " + templateOrganValue);
		if (templateOrganValue.toLowerCase().contains("liver")) {
			return "Liver";
		} else if (templateOrganValue.toLowerCase().contains("lung")) {
			return "Lung";
		} else if (templateOrganValue.toLowerCase().contains("breast")) {
			return "Breast";
		} else if (templateOrganValue.toLowerCase().contains("bone")) {
			return "Bone";
		} 
		//missing organ types (removing ifs doesn't work as the data coming from template is not just liver, it is Liver CT)
		else if (templateOrganValue.toLowerCase().contains("brain")) {
			return "Brain";
		} else if (templateOrganValue.toLowerCase().contains("rats")) {
			return "Rats";
		} else if (templateOrganValue.toLowerCase().contains("knee")) {
			return "Knee";
		}
		throw new PluginServletException("Invalid input.", "Invalid input: templateOrganValue=" + templateOrganValue);
		
	}

	private static String getUIDFromAIM(String tag, String attribute, String aimFileContents)
			throws PluginServletException
	{
		return getUIDFromAIM(tag, attribute, aimFileContents, 1);
	}
	private static String getUIDFromAIM(String tag, String attribute, String aimFileContents, int index)
			throws PluginServletException
	{

		tag = tag.toLowerCase();
		attribute = attribute.toLowerCase();
		aimFileContents = aimFileContents.toLowerCase();

		int fromIndex = 0;
		int tagIndex = 0;
		while (fromIndex < aimFileContents.length() && tagIndex != -1 && index > 0)
		{
			tagIndex = aimFileContents.indexOf(tag, fromIndex);
			index--;
			fromIndex = tagIndex + tag.length();
			//log.info(" tagIndex=" + tagIndex + " fromIndex=" + fromIndex + " index=" + index);
		}
		
		if (tagIndex > 0) {
			int attribIndex = aimFileContents.indexOf(attribute, tagIndex);

			if (attribIndex > 0) {

				int start = aimFileContents.indexOf("\"", attribIndex);
				int end = aimFileContents.indexOf("\"", start + 1);

				String retVal = aimFileContents.substring(start, end + 1);
				retVal = retVal.replace('"', ' ').trim();
				return retVal;
			} else {
				throw new PluginServletException("input error", "Didn't find attribute: " + attribute + " in tag:" + tag);
			}
		} else {
			log.warning("Didn't find tag: " + tag);
			return null;
		}
	}

}
