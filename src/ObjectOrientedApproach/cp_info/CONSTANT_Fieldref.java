package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Fieldref implements CP_Info {

    int tag=9;
    short class_index;
    short name_and_type_index;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        return new Object[]{stream.readUnsignedShort(), stream.readUnsignedShort()};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(tag);
        stream.writeShort(class_index);
        stream.writeShort(name_and_type_index);
    }
}
