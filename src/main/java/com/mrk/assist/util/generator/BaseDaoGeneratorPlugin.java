package com.mrk.assist.util.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.mybatis.generator.logging.Log;
import org.mybatis.generator.logging.LogFactory; 

public class BaseDaoGeneratorPlugin extends PluginAdapter {
	public static final String BASE_DAO="BaseDao";
	public static final String BASE_DAOP="BaseDaoPre";
	public static final String BASE_DAO_IMP="com.mrk.sys.dao.pre";
	private Log logger;

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		interfaze.getImportedTypes().clear();
		List<IntrospectedColumn> Columns = introspectedTable.getPrimaryKeyColumns();
		int knum = Columns.size();
		if (knum == 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String a, impBaseDao;
		if (gethasEx(introspectedTable)) {
			a = BASE_DAOP + "<" + introspectedTable.getBaseRecordType() + ",";
			impBaseDao = BASE_DAO_IMP + "." + BASE_DAOP;
		} else {
			a = BASE_DAO + "<" + introspectedTable.getBaseRecordType() + ","
					+ introspectedTable.getExampleType() + ",";
			FullyQualifiedJavaType imp3 = new FullyQualifiedJavaType(introspectedTable.getExampleType());
			interfaze.addImportedType(imp3);
			impBaseDao = BASE_DAO_IMP + "." + BASE_DAO;
		}

		FullyQualifiedJavaType imp = new FullyQualifiedJavaType(impBaseDao);
		FullyQualifiedJavaType imp2 = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		interfaze.addImportedType(imp);
		interfaze.addImportedType(imp2);
		// 如果主键只有一个 没有单独生成主键类 处理泛型接口类别
		if (Columns.size() == 1) {
			JavaTypeResolver javaTypeResolver = new JavaTypeResolverDefaultImpl();
			FullyQualifiedJavaType fullyQualifiedJavaType = javaTypeResolver.calculateJavaType(Columns.get(0));
			a = a + fullyQualifiedJavaType + ">";
			interfaze.addImportedType(fullyQualifiedJavaType);
		} else {
			a = a + introspectedTable.getPrimaryKeyType() + ">";
			FullyQualifiedJavaType imp4 = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
			interfaze.addImportedType(imp4);
		}

		FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(a);
		interfaze.addSuperInterface(fqjt);

		interfaze.getMethods().clear();
		interfaze.getAnnotations().clear();
		logger = LogFactory.getLog(getClass());
		logger.debug(a);
		return true;
	}

	// 判断是否生成ex类
	public boolean gethasEx(IntrospectedTable introspectedTable) {
		TableConfiguration tableConfiguration = introspectedTable.getTableConfiguration();
		Boolean b1 = tableConfiguration.isCountByExampleStatementEnabled();
		Boolean b2 = tableConfiguration.isUpdateByExampleStatementEnabled();
		Boolean b3 = tableConfiguration.isSelectByExampleStatementEnabled();
		Boolean b4 = tableConfiguration.isDeleteByExampleStatementEnabled();
		if (b1 && b2 && b3 && b4) {
			return false;
		}
		return true;
	}

}
