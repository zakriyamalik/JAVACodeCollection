import java.util.ArrayList;

public class InvertClass {
    public String[] invertor(String [] fileData)
    {
        String []newFileData=new String[fileData.length];
        StringBuffer [] newFileBuffer=new StringBuffer[fileData.length];

        for(int i = 0; i < fileData.length; i++)
        {
            System.out.println("fileData[ "+i+" ]"+fileData[i]);
            newFileBuffer[i]=new StringBuffer(fileData[i]);
        }
        for(int i=0;i<fileData.length;i++) {
            for(int j = 0; j < fileData[i].length(); j++) {


                if(Character.isLowerCase(fileData[i].charAt(j))) {
                   newFileBuffer[i].setCharAt(j, Character.toUpperCase(fileData[i].charAt(j)));
                }
               else if(Character.isUpperCase(fileData[i].charAt(j))) {

                    newFileBuffer[i].setCharAt(j, Character.toLowerCase(fileData[i].charAt(j)));
                }
            }

        }


//        ArrayList<Character> charArray=new ArrayList<Character>();
//        for(int i=0;i<fileData.length;i++)
//        {
//            charArray.add(fileData[i].charAt(0));
//
//
//
//        }
//        for(int i=0;i<charArray.size();i++)
//        {
//            System.out.println(charArray.get(i));
//        }





        System.out.println("\nString after case conversion : \n");
        for(int i=0;i<newFileBuffer.length;i++) {
            newFileData[i] = newFileBuffer[i].toString();
        }

        return newFileData;
    }





}
