package com.zlb.bsdiff;

public class BsDiff {
    static{
        System.loadLibrary("bsdiff");
    }


    /**
     *
     * @param oldPath
     * @param newPath
     * @param diffPath
     * @return
     */
    public static native int bsDiff(String oldPath,String newPath,String diffPath);

    /**
     *
     * @param oldPath
     * @param newPath
     * @param diffPath
     * @param size newFile length
     * @return
     */
    public static native int bsPatch(String oldPath,String newPath,String diffPath,int size);
}
