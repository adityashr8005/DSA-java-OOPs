package CodeWars;

/*
Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"

"The_Stealth_Warrior" gets converted to "TheStealthWarrior"

"The_Stealth-Warrior" gets converted to "TheStealthWarrior"
 */
public class IntoCamelCase {

    public static String toCamelCase(String s){
        StringBuilder str = new StringBuilder();
        boolean willCapital = false;

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '-' || ch == '_'){
                willCapital = true;
            }else {
                if (willCapital){
                    str.append(Character.toUpperCase(ch));
                    willCapital = false;
                }else {
                    str.append(ch);
                }
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "the-stealth-warrior";

        System.out.println(toCamelCase(s));
    }
}
