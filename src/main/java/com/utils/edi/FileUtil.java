package com.utils.edi;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	protected static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    protected static final String ENCODING_GBK="GBK";
    protected static final String ENCODING_UTF8="UTF-8";

	/**
	 * 取得某个目录下的所有文件列表
	 * 
	 * @param directoryPath 文件夹路径
	 * @param suffix 文件后缀名，[空], [*], [*.*] 均表示取得所有文件
	 * @param prefix 文件前缀名，[空], [*], [*.*] 均表示取得所有文件
	 * @param isDepth 是否遍历子目录
	 */
	public static List<File> getAllFilesFromDir(String directoryPath, String suffix, String prefix, boolean isdepth) {
		List<File> outputFiles = new ArrayList<File>();
		File directory = new File(directoryPath);
		if(directory.isDirectory()) {
			File[] files = directory.listFiles();
			for(File f : files) {
				//文件夹
				if(f.isDirectory()) {
					//是否遍历子目录
					if(isdepth) {
						List<File> filesSub = getAllFilesFromDir(f.getAbsolutePath(), suffix, prefix, isdepth);
						outputFiles.addAll(filesSub);
					}
				}
				//文件
				else {

					// 后缀满足
					if(        (StringUtils.isBlank(suffix) || "*".equals(suffix) || "*.*".equals(suffix))
							|| (StringUtils.isNotBlank(suffix) && f.getAbsolutePath().endsWith(suffix)) ) {

						// 前缀满足
						if(        (StringUtils.isBlank(prefix) || "*".equals(prefix) || "*.*".equals(prefix))
								|| (StringUtils.isNotBlank(prefix) && f.getName().startsWith(prefix)) ) {
							outputFiles.add(f);
						}

					}
				}
			}
		} else {
			logger.error("请选择目标数据包目录！");
		}
		
		return outputFiles;
	}

	/**
	 * 取得某个目录下的所有文件列表
	 * 
	 * @param directoryPath 文件夹路径
	 * @param suffix 文件后缀名，[空], [*], [*.*] 均表示取得所有文件
	 * @param isDepth 是否遍历子目录
	 */
	public static List<File> getAllFilesFromDir(String directoryPath, String suffix, boolean isdepth) {

		return getAllFilesFromDir(directoryPath, suffix, "*", isdepth);
	}
    
	/**
	 * 单个文件移动（或文件夹）
	 * 
	 * @param oldPath
	 * @param targetPath
	 * @return
	 */
	public static boolean moveToFile(String oldPath ,String targetPath) {

		try {
			File newFile = new File(targetPath);
			return moveToFile(oldPath, newFile.getParent(), newFile.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 单个文件移动（或文件夹）
	 * 
	 * @param oldPath
	 * @param targetPath
	 * @param targetFileName
	 * @return
	 */
	public static boolean moveToFile(String oldPath ,String targetDir, String targetFileName){
		try {
			File oldFile = new File(oldPath);
			File newFile = new File(targetDir);
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			File fnew = new File(newFile + "/" + targetFileName);
			if(fnew.exists()) {
				fnew.delete();
			}
			return oldFile.renameTo(fnew);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * 复制单个文件
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf.txt
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        // 复制
        InputStream inStream = null;
        try {
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                inStream = new FileInputStream(oldPath); // 读入原文件
                copyFile(inStream, newPath);
                logger.info("复制成功！原文件名：" + oldPath);
            } else {
            	throw new FileNotFoundException("文件不存在：" + oldPath);
            }
        }
        catch (FileNotFoundException e) {
            logger.error("复制文件出现异常，文件不存在：" + e.getMessage(), e);
        }
        finally {
        	StreamUtil.close(inStream, logger);
        }
    }
 
    /**
     * 从输入流中复制单个文件
     * 
     * @param oldInputStream
     *            InputStream 原文件输入流
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(InputStream oldInputStream, String newPath) {
        // 判断新文件目录若不存在，则将其创建
        File newDir = (new File(newPath)).getParentFile();
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
        //		// 判断新文件存在，则将其删除 TODO
        //		File newFile = new File(newPath);
        //		if (newFile.exists()) {
        //			newFile.deleteOnExit();
        //		}
        // 复制
        FileOutputStream fs = null;
        try {
            int bytesum = 0;
            int byteread = 0;
            if (oldInputStream != null) { // 文件存在时
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                while ((byteread = oldInputStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                fs.flush();
                logger.info("文件内容复制成功！文件大小：" + bytesum);
                logger.info("文件的目标路径：" + newPath);
            } else {
            	throw new FileNotFoundException("输入流为空！");
            }
        }
        catch (FileNotFoundException e) {
            logger.error("复制文件出现异常，文件不存在：" + e.getMessage(), e);
        }
        catch (IOException e) {
            logger.error("复制文件出现异常，读写文件时发生异常：" + e.getMessage(), e);
        }
        finally {
            StreamUtil.close(oldInputStream, logger);
            StreamUtil.close(fs, logger);
        }
    }

    /**
     * 读文本文件
     * 
     * @param skipEnter 去除回车
     */
    public static String readTxtFileToString(String filePath, String encodeing, boolean skipEnter) {
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        try {
            fis = new FileInputStream(filePath);
            isr = new InputStreamReader(fis, encodeing);
            in = new BufferedReader(isr);
            char cbuf[] = new char[1024];
            int length_;
            while ((length_ = in.read(cbuf)) != -1) {
            	String tempbyte = new String(cbuf, 0, length_);
            	if(skipEnter) {
            		tempbyte = tempbyte.replace("\n", "");
            		// tempbyte = tempbyte.replace("'\n", "'");
            	}
                sb.append(tempbyte);
            }
        }
        catch (Exception e) {
            logger.error("读取文本文件失败：", e);
        }
        finally {
        	StreamUtil.close(in, logger);
        	StreamUtil.close(isr, logger);
        	StreamUtil.close(fis, logger);
        }
        return sb.toString();
    }

    /**
     * 写文本文件
     */
    public static boolean writeStringToTxtFile(String strContent, String filePath, String encodeing) {

    	
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        PrintWriter out = null;
        try {
        	fos = new FileOutputStream(filePath);
        	osw = new OutputStreamWriter(fos, "UTF-8");
        	out = new PrintWriter(osw, false);

        	out.println(strContent);
        }
        catch (Exception e) {
            logger.error("写文本文件出现未知异常：", e);
        }
        finally {
        	StreamUtil.close(out, logger);
        	StreamUtil.close(osw, logger);
        	StreamUtil.close(fos, logger);
        }
        return true;
    }

//    public static void main(String[] args) {
//    	String str = FileUtil.readTxtFileToString("C:\\Users\\600107\\Desktop\\7642f6b0ee334db8bccb964f052d0844\\_wordToHtml.html", "UTF-8");
//    	System.out.println(str);
//    }
}
