package core.directory;

public class Checker {
    public int check(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr == null) {
            throw new MyArraySizeException();
        }
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings != null) {
                if (strings.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] tmp = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try {
            int check = new Checker().check(tmp);
            System.out.println("check = " + check);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Найдена ошибка в " + (e.getColumn()+1) + " элементе на строке "+ (e.getRow()+1));
            e.printStackTrace();
        }
    }
}