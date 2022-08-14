package designpattern;

public class AdapterPattern {
    public static void main(String[] args) {
        new Adapter(new Speaker()).translate();
    }
}


class Speaker{
    public String speak() {
        return "China No.1";
    }
}

interface Translator{
    public String translate();
}

class Adapter implements Translator{

    private Speaker speaker;
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        // 适配、翻译
        System.out.println(result + "翻译为中国第一");
        return result;
    }
}
