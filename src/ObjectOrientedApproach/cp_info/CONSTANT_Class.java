package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Class implements CP_Info{

    int tag=7;
    short name_index;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        return new Object[]{stream.readUnsignedShort()};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeByte(tag);
        stream.writeShort(name_index);
    }

    public void write(DataOutputStream stream, int tag, short name_index) throws IOException {
        this.tag =tag;
        this.name_index = name_index;
        write(stream);
    }
}
