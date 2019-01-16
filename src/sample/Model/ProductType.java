package sample.Model;

/**
 * Created by misiek on 2017-03-20.
 */
public enum ProductType {

    BEVERAGE{
        @Override
        public String toString(){
            return "Napoje";
        }
    },
    BAKERY{
        @Override
        public String toString(){
            return "Pieczywo";
        }
    },
    CANDIES{
        @Override
        public String toString(){
            return "Słodycze";
        }
    },
    MEAT{
        @Override
        public String toString(){
            return "Mjenso";
        }
    },
    FRUITS{
        @Override
        public String toString() { return "Owoce"; }
    },
    DEFAULT;
    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
