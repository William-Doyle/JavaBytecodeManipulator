package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Long implements CP_Info{

    int tag=5;
    long value;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
//        int high_bytes=stream.readInt();
//        int low_bytes = stream.readInt();
//        value = ((long) high_bytes << 32) + low_bytes;
        return new Object[]{stream.readLong()};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
        stream.writeLong(value);
    }
}
