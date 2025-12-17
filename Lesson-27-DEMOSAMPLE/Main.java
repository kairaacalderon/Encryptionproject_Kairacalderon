class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    print(reverse("strawberry"));
    print(decrypt("trswbarrey"));
    String msg1= "trswbarrey";
    print(encode(msg1));
    print(decode("ustxcbssfz"));
    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] latin1 = new char[5];
    latin1[0] = 'u'; 
    latin1[1] = 't';
    latin1[2] = 'c';
    latin1[3] = 'b';
    latin1[4] = 'z';

    char[] latin2 = new char[5];
    latin2[0] = '\u1E73';  // this is letter u in latin ṳ
    latin2[1] = '\u1E6D';  // this is letter t in latin ṭ
    latin2[2] = '\u1E09';  // this is letter c in latin ḉ
    latin2[3] = '\u1E05';  // this is letter b in latin ḅ
    latin2[4] = '\u1E95';  // this is letter z in latin ẕ

  print(Encryption("ustxcbssfz",latin1,latin2));
  print(decryption("ṳsṭxḉḅssfẕ",latin2,latin1));

    // Encoding message
    //String file = Input.readFile("test.txt");

    //substituion
    //String encodedMsg1 = subEncryption(file,latin1,latin2);
    //Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    //String encodedMsg2 = encode(encodedMsg1);
    //Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    //String encodedMsg3 = reverse(encodedMsg2);
    //Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    //String file2 = Input.readFile("Encode1.txt");
    
    //String decodedMsg1 = reverse(file2);
    //Input.writeFile("Decode1.txt", decodedMsg1);
    
    //String decodedMsg2 = decode(decodedMsg1);
    //Input.writeFile("Decode2.txt", decodedMsg2);
    
     //String decodedMsg3 = subEncryption(decodedMsg2, latin2, latin1);
    //Input.writeFile("Decode1.txt", decodedMsg3);
    
    
  }
  // Level 1 reverse string
  String reverse(String txt){
    String bld ="";
    for(int x=0; x<=txt.length()-3; x+=3){
      bld+=txt.substring(x+1,x+3)+txt.substring(x,x+1);
    }
    if(txt.length()%3==1){
      bld+= txt.substring(txt.length()-1);
    }
    return bld;
  }

  //decrypt 
    String decrypt(String txt){
    String bld ="";
    for(int x=0; x<=txt.length()-3; x+=3){
      bld+=txt.substring(x+2,x+3)+txt.substring(x,x+2);
    }
    if(txt.length()%3==1){
      bld+= txt.substring(txt.length()-1);
    }
    return bld;
  }
  
  
  //Level 2 Cipher encoding with no wrapping
  String encode(String txt){
    String bld="";
    char ch =' ';
    int ascii=0;
    for(int x=0; x<=txt.length()-1; x++){
      ch = txt.charAt(x);
      ascii = (int) ch;
      ascii++;
      ch = (char) ascii;
      bld+=ch;
    }
    return bld;
  }

  
  String decode(String txt){
    String bld="";
   char ch =' ';
    int ascii=0;
    for(int x=0; x<=txt.length()-1; x++){
      ch = txt.charAt(x);
      ascii = (int) ch;
      ascii--;
      ch = (char) ascii;
      bld+=ch;
    }
    return bld;
  }

  // Level 3 Substituion encoding
  String Encryption(String d, char[] latin1, char[] latin2){
    String bld="";
   char ch ='\0';
   for(int x=0; x<=d.length()-1; x++){
    ch=d.charAt(x);
    bld+=sub(ch,latin1,latin2);
   }
    return bld;
  }

  char sub(char ch, char[] latin1, char[] latin2){
    String bld="";
   for(int x=0; x<latin1.length; x++){
    if(latin1[x]==ch){
      return latin2[x];
    }
   }
    return ch;
  }

  //decrypting part 
    String decryption(String d, char[] latin1, char[] latin2){
    String bld="";
   char ch ='\0';
   for(int x=0; x<=d.length()-1; x++){
    ch=d.charAt(x);
    bld+=subz(ch,latin2,latin1);
   }
    return bld;
  }

  char subz(char ch, char[] latin1, char[] latin2){
    String bld="";
   for(int x=0; x<latin1.length; x++){
    if(latin2[x]==ch){
      return latin1[x];
    }
   }
    return ch;
  }

  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}