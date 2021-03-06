//package com.lk.java.common.utils;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.input.SAXBuilder;
//
//public class ParseXmlUtil {
//	
//	public static Map<String, String> doXMLParse(String strxml) throws Exception {
//		if (StringUtils.isNull(strxml)) {
//			return null;
//		}
//
//		Map<String, String> m = new HashMap<String, String>();
//		InputStream in = String2Inputstream(strxml);
//		SAXBuilder builder = new SAXBuilder();
//		Document doc = builder.build(in);
//		Element root = doc.getRootElement();
//		List list = root.getChildren();
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			Element e = (Element) it.next();
//			String k = e.getName();
//			String v = "";
//			List children = e.getChildren();
//			if (children.isEmpty()) {
//				v = e.getTextNormalize();
//			} else {
//				v = getChildrenText(children);
//			}
//
//			m.put(k, v);
//		}
//
//		// 关闭流
//		in.close();
//
//		return m;
//	}
//	
//	/**
//	 * 获取子结点的xml
//	 * 
//	 * @param children
//	 * @return String
//	 */
//	@SuppressWarnings("rawtypes")
//	private static String getChildrenText(List children) {
//		StringBuffer sb = new StringBuffer();
//		if (!children.isEmpty()) {
//			Iterator it = children.iterator();
//			while (it.hasNext()) {
//				Element e = (Element) it.next();
//				String name = e.getName();
//				String value = e.getTextNormalize();
//				List list = e.getChildren();
//				sb.append("<" + name + ">");
//				if (!list.isEmpty()) {
//					sb.append(getChildrenText(list));
//				}
//				sb.append(value);
//				sb.append("</" + name + ">");
//			}
//		}
//
//		return sb.toString();
//	}
//
//	private static InputStream String2Inputstream(String str) {
//		return new ByteArrayInputStream(str.getBytes());
//	}
//}
