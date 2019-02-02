package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface CP_Info {
    int tag = 0;

    Object[] read(DataInputStream stream) throws IOException;

    void write(DataOutputStream stream) throws IOException;
}
