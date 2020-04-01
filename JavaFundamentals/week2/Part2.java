/*Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
This assignment will determine if a DNA strand has a gene in it by using the simplified algorithm from the lesson, but organizing the code in a slightly different way. You will modify the method findSimpleGene to have three parameters, one for the DNA string, one for the start codon and one for the stop codon.

Specifically, you should do the following:

1. Create a new Java Class named Part2 in the StringsFirstAssignments project.

2. Copy and paste the two methods findSimpleGene and testSimpleGene from the Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer with lowercase letters, the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.*/public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String endCodon){
        int startIndex=dna.indexOf(startCodon);
        if(startIndex==-1)
            return "";
        int endIndex=dna.indexOf(endCodon,startIndex+3);
        if(endIndex==-1)
            return "";
        if((endIndex+3-startIndex)%3==0)
            return dna.substring(startIndex,endIndex+3);
        return "";
    }
    public void testSimpleGene(){
        String arr[]={"ATGCTCTCTCTAA","TCTCTCTCTAA","ATGTCTCTCTC","ATGCTCTCTTAA","ATCTATACT","atgtcctcctaa"};
        for(String a:arr){
            if(Character.isLowerCase(a.charAt(0)))
                System.out.println(a+"  :  "+findSimpleGene(a,"atg","taa"));
            else
                System.out.println(a+"  :  "+findSimpleGene(a,"ATG","TAA"));
        }
    }

    public static void main(String[] args) {
        Part2 gene=new Part2();
        gene.testSimpleGene();
    }
}
