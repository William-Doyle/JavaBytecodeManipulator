package ObjectOrientedApproach;

import ObjectOrientedApproach.cp_info.CP_Info;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class ClassReader {
    private static DataInputStream stream;

    private static Map<String, Object> class_data = new LinkedHashMap<>();

    private static final Map<Integer, String> CONSTANT_POOL_TAGS= createConstantTags();
   


    public ClassReader(){
        try {
            stream = new DataInputStream(new FileInputStream(new File("C:\\Users\\WTD39\\comp1100\\Java Bytecode Manipulator\\out\\production\\Java Bytecode Manipulator\\HelloWorld.class")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a map of
     * @return
     */
    private static LinkedHashMap<Integer, String> createConstantTags(){
        Map<Integer, String> temp_constant_table = new LinkedHashMap<>();
        temp_constant_table.put(7, "CONSTANT_Class");
        temp_constant_table.put(9, "CONSTANT_Fieldref");
        temp_constant_table.put(10, "CONSTANT_Methodref");
        temp_constant_table.put(11, "CONSTANT_InterfaceMethod");
        temp_constant_table.put(8, "CONSTANT_String");
        temp_constant_table.put(3, "CONSTANT_Integer");
        temp_constant_table.put(5, "CONSTANT_Long");
        temp_constant_table.put(6, "CONSTANT_Double");
        temp_constant_table.put(12, "CONSTANT_NameAndType");
        temp_constant_table.put(1, "CONSTANT_Utf8");
        temp_constant_table.put(15, "CONSTANT_MethodHandle");
        temp_constant_table.put(16, "CONSTANT_MethodType");
        temp_constant_table.put(18, "CONSTANT_InvokeDynamicType");
        
        return new LinkedHashMap(temp_constant_table);
    }

    //u1 = readUnsignedByte
    //u2 = readUnsignedShort
    //u4 = readInt
    private void readFile(DataInputStream stream){
        try {
            class_data.put("magic", String.format("%02X ", stream.readUnsignedByte())+String.format("%02X ", stream.readUnsignedByte())+String.format("%02X ", stream.readUnsignedByte())+String.format("%02X ", stream.readUnsignedByte()));
            class_data.put("minor_version", stream.readUnsignedShort());
            class_data.put("major_version", + stream.readUnsignedShort());
            int constant_pool_count = stream.readUnsignedShort();
            int cpsize = constant_pool_count-1;
            class_data.put("const_pool_count", constant_pool_count);
            class_data.putAll(readConstantPool(stream, constant_pool_count));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private LinkedHashMap<String, Object> readConstantPool(DataInputStream stream, int constant_pool_count) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        Map<String, Object> constant_pool_data = new LinkedHashMap<>();

        //iterate through all items in the constant pool
        for(int pool_index=1; pool_index<constant_pool_count; pool_index++){
            //get the ObjectOrientedApproach.cp_info u1 tag
            int tag = stream.readUnsignedByte();

            //get the associated constant_type
            String constant_type = CONSTANT_POOL_TAGS.get(tag);

            //find the class associated with the constant_type
            Class<?> clazz = Class.forName("ObjectOrientedApproach.cp_info." + constant_type);
            CP_Info constant_reader = (CP_Info) clazz.newInstance();

            //call the respective read method and add the data
            constant_pool_data.put(constant_type + ": ", constant_reader.read(stream));

        }

        //return the constructed pool
        return new LinkedHashMap<>(constant_pool_data);
    }

    public void print(Map<String, Object> map){
      map.forEach((k,v)->System.out.println(k + " " + v));
    }

    public static void main(String[] args){
        ClassReader cl = new ClassReader();
        cl.readFile(stream);
        cl.print(class_data);
    }


}
