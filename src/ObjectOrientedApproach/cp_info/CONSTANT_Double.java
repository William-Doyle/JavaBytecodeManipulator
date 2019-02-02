package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Double implements CP_Info {

    int tag=6;
    double value;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
        int bits;
        //int high_bytes=stream.readInt();
//        int low_bytes = stream.readInt();
//        bits = ((long) high_bytes << 32) + low_bytes;

      //  if(value==)
        return new Object[]{stream.readDouble()};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {

    }
}
