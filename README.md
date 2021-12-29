## Introduction

Used for Android platform to generate difference package patch of two files or use version file and patch to synthesize a new file

### Related methods

##### public static native int bsDiff(String oldPath,String newPath,String diffPath);
oldPath is the original file path, newPath is the current latest file path, diffPath is the patch file path to be generated soon

##### public static native int bsPatch(String oldPath,String newPath,String diffPath,int size);
oldPath is the original file path, newPath is the file path to be generated, diffPath is the patch file path, and size is the number of bytes of the latest file.
