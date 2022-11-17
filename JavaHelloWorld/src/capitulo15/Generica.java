package capitulo15;

public class Generica <T>{

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Generica{" +
                "value=" + value +
                '}';
    }
}
