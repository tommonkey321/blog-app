/**
 * $Id: FileOperateFactory.java,v 1.0 17/2/16 下午1:41 zhangruiping Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.bp;

import com.tommonkey.utils.bp.operator.ExcelOperator;
import com.tommonkey.utils.bp.operator.TextOperator;

/**
 * @author zhangruiping
 * @version $Id: FileOperateFactory.java,v 1.1 17/2/16 下午1:41 zhangruiping Exp $
 *          Created on 17/2/16 下午1:41
 */
public class FileOperateFactory {

    public static com.tommonkey.utils.bp.operator.FileOperator getFileOperator(Integer fileTemplateType) throws Exception {
        if (fileTemplateType == Constants.FileType.EXCEL) {
            return new ExcelOperator();
        } else if (fileTemplateType == Constants.FileType.EXCEL_XLS) {
            return new ExcelOperator();
        } else if (fileTemplateType == Constants.FileType.EXCEL_XLSX) {
            return new ExcelOperator();
        } else if (fileTemplateType == Constants.FileType.CVS) {
            return new com.tommonkey.utils.bp.operator.CSVOperator();
        } else if (fileTemplateType == Constants.FileType.TXT) {
            return new TextOperator();
        }
        throw new Exception("未找到对应的文件解析模板TemplateType=[" + fileTemplateType + "]");
    }
}