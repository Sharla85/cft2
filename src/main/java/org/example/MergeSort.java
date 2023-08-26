package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class MergeSort <T> {
    String output;
    String dir;
    List <String> inputs; //имена файлов в кототрых наши числа нах-ся
    boolean order;
    public MergeSort (String dir,List <String> inputs, String output, boolean order){
        //в круглых скобках выше это то, что мы присвоим в переменные нашего класса
        this.dir = dir;
        this.inputs = inputs;
        this.output = output;
        this.order = order;
        //переменным, кот в классе мы присвоили значения, которые в () (инициализация)
    }
    public List <T> getArray (String input) throws IOException {
        // <T> означает, что тип не определен и таким образом мы его заявляем
        List<T> array = new ArrayList<>();
        // создали список в кот будем заносить файл
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dir+"input\\"+input))){
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                array.add((T)line); //заносим считанную строку в массив

            }

        }
        return array;
    }
   public void fillOutput (){
        int n = inputs.size();
        //заводим список элементов, которые будут находиться в output
       List<T> outputs = new ArrayList<>();
       for (int i = 0; i<n;i++)
       {
           try {
               outputs.addAll(getArray(inputs.get(i)));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

       }
       n=outputs.size();
       try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(dir+"output\\"+output))){
          for (int i = 0;i<n; i++){
              bufferedWriter.write(String.valueOf(outputs.get(i))+'\n');
          }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }
}
