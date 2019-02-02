package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_InterfaceMethodref implements CP_Info {

    int tag=11;
    short class_index;
    short name_and_type_index;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        return new Object[]{class_index, name_and_type_index};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(tag);
        stream.writeShort(class_index);
        stream.writeShort(name_and_type_index);
    }
}
