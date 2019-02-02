package FunctionalApproach;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClassReader {

    /**Constants**/

    //file header "magic word"
    public static final int HEADER = 0xcafebabe;

    //constant pool types
    public static final byte CONSTANT_Utf8 =                1;
    public static final byte CONSTANT_Integer =             3;
    public static final byte CONSTANT_Float =               4;
    public static final byte CONSTANT_Long=                 5;
    public static final byte CONSTANT_Double =              6;
    public static final byte CONSTANT_Class =               7;
    public static final byte CONSTANT_String =              8;
    public static final byte CONSTANT_Fieldref =            9;
    public static final byte CONSTANT_Methodref =           10;
    public static final byte CONSTANT_InterfaceMethodref =  11;
    public static final byte CONSTANT_NameAndType =         12;
    public static final byte CONSTANT_MethodHandle =        15;
    public static final byte CONSTANT_MethodType =          16;
    public static final byte CONSTANT_InvokeDynamic =       18;

    //constant pool mapping
    private static String[] POOL_MAPPING = {
            null, "CONSTANT_Utf8", null, "CONSTANT_Integer", "CONSTANT_Float", "CONSTANT_Long",
            "CONSTANT_Double", "CONSTANT_Class", "CONSTANT_String", "CONSTANT_Fieldref", "CONSTANT_Methodref",
            "CONSTANT_InterfaceMethodref", null, null, "CONSTANT_NameAndType", "CONSTANT_MethodHandle", "CONSTANT_MethodType", null,  "CONSTANT_InvokeDynamic"};

    //parses a class at runtime
    static void parseRtClass(Class<?> clazz) throws IOException, URISyntaxException{
        URL url = clazz.getResource(clazz.getSimpleName()+".class");
        if(url==null) throw new IOException("Bytecode of " + clazz + "is unreadable");
        parse(ByteBuffer.wrap(Files.readAllBytes(Paths.get(url.toURI()))));
    }

    static void parseClassFile(Path path) throws IOException{
        ByteBuffer bb;
        try(FileChannel ch = FileChannel.open(path, StandardOpenOption.READ)){
            bb=ch.map(FileChannel.MapMode.READ_ONLY, 0, ch.size());
        }
        parse(bb);
    }

    static void parse(ByteBuffer bb){
        
    }

}
