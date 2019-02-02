package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_String implements CP_Info {

    int tag =8;
    short string_index;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        return new Object[]{stream.readUnsignedShort()};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.write(tag);
        stream.writeShort(string_index);
    }
}
