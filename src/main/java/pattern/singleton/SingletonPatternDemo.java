package pattern.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
//        new SingleObject();
//        SingleObject instance = SingleObject.getInstance( );
//        instance.showMessage();

        System.out.println(Singleton.INSTANCE.getMsg() );

        Singleton[] singletons = Singleton.values( );
        for(Singleton value : Singleton.values()) {
            System.out.println(value );
        }
        System.out.println(singletons );
//        我是一个实例
//        INSTANCE
//        ERROR
//        MISSING_PARAMETER
//        [Lpattern.singleton.Singleton;@5a10411
    }

}
