package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Integer implements CP_Info {

    int tag=3;
    int bytes;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        return new Object[stream.readInt()];
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(bytes);
    }
}
