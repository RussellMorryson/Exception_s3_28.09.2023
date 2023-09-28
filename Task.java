import java.util.List;
import java.util.Scanner;

class Task {
    public static void main (String [] args) {      
        List <Integer> array  = userInput ();

       
    }   

    public bool searchSymbolsA (String text) {
         int strlen = 0;
         String alphabet = "абвгдеёжзийклмнопрстуфхцшщчъыьэюя";
         String ltext = text.toLowerCase();
         for(char i : ltext) {
            for(char j : alphabet) {
                if (i == j) { 
                    strlen +=1; 
                }
            }
        }
        return strlen == text.length();
    }

    public bool searchSymbolsN (String date) {
         int strlen = 0;
         String numbers = "0123456789";
         for(char i : date) {
            for(char j : numbers) {
                if (i == j) { 
                    strlen +=1; 
                }
            }
        }
        return strlen == date.length();
    }
    


    
    public Hashmap userInput () {
        Scanner scan = new Scanner(System.in); 
        List<String> arrList = new ArrayList();
        
        bool access = true;
        String inputText = "";
        String text = "";
        while (access) {
            System.out.println("Введите в произвольном порядке ФИО, дату рождения, номер телефона и пол через пробелы в формате: \n");
            System.out.println("ФИО - Фамилия Имя Отчетство \n");
            System.out.println("Дата рождения - дд.мм.гггг \n");
            System.out.println("Номер телефона - 89991234567 \n");
            System.out.println("Пол - f или m \n");
            
            inputText = scan.nextLine();

            for (int i = 0; i < inputText.length(); i++) {                    
                if (inputText[i] != ' ') {
                    text +=inputText[i];
                } else {
                    arrList.add(text);
                    text = "";
                    vol += 1;
                }
            }

            HashMap<String, String> userInfo = new HashMap<>();
            //List<Integer> arrNumbers = new ArrayList('0','1','2','3','4','5','6','7','8','9');
            String alphabet = "абвгдеёжзийклмнопрстуфхцшщчъыьэюя";
            //List<Integer> arrSymbols = new ArrayList('.',',','"',';',':','!','`','~','?', '',
            //                                         '[',']','{','}','(',')','<','>','#','$',
            //                                         '%','^','&','*','/','+','-','@','.','=','|','\\');          
            
            //int error = 0;
            //int strlen = 0;
            int fio = 1;
            String temp = "";
            for(int h =0; h < arrList.length(); h++) {
                temp = arrList[h];
                String sur = temp[temp.length() - 1] + temp[temp.length() - 2];
                String patro = temp[temp.length() - 1] + temp[temp.length() - 2] + temp[temp.length() - 3];
                int 
                temp[temp.length() -1];
                temp[temp.length() -1]
                temp[temp.length() -1]



                // Проверка фамилия ли это
                if (sur == "ов" || sur == "ва" || sur == "на" || sur == "ин" || sur == "ев") {                   
                    fio +=1;
                    if (searchSymbols(temp)) {
                        userInfo.put("Фамилия" , temp);
                        arrList.remove(h);
                    } else {
                        System.out.println("В тексте имеются посторонние символы\n");
                        //// Необходимо обработать ошибку
                    }         
                } else if (fio == 2) {
                    fio +=1;
                    if (searchSymbols(temp)) {
                        userInfo.put("Имя" , temp);
                        arrList.remove(h);
                    } else {
                        System.out.println("В тексте имеются посторонние символы\n");
                        //// Необходимо обработать ошибку
                    }       
                } else if (patro == "вич" ||patro == "вна") {
                    if (searchSymbols(temp)) {
                        userInfo.put("Отчество" , temp);
                        arrList.remove(h);
                    } else {
                        System.out.println("В тексте имеются посторонние символы\n");
                        //// Необходимо обработать ошибку
                    }
                } else if ((temp.length() == 10 && temp[2] == '.' && temp[5] == '.') || 
                (temp.length() == 10 && temp[2] == '.' && temp[7] == '.') || 
                (temp.length() == 10 && temp[4] == '.' && temp[7] == '.')) {
                    
                }


                


// Петров - Петрова
// Сидоров - Сидорова
// Гильмутдинов - Гильмутдинова
// Хорт
                "Name"
                "Surname"
                "Patronymic"
                "PhoneNumber"
                "DateofBirth"
                "Floor"

                
            }

          

        }
        



    }


}


/*
for(int i =0; i < temp.length(); i++) {
                        for(char n : arrNumbers) {
                            if (temp[i] == n) {
                                System.out.println("В введенной Вами строке имеется число: " + n + "\n");
                                error +=1;
                                break;
                            }
                        }
                        for(char s : arrSymbols) {
                            if (temp[i] == s) {
                                System.out.println("В введенной Вами строке имеется символ: " + s + "\n");
                                error +=1;
                                break;
                            }
                        }
                    } */