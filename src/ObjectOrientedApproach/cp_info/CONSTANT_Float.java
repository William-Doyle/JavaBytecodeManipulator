package ObjectOrientedApproach.cp_info;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Float implements CP_Info {

    int tag;
    int bits;

    @Override
    public Object[] read(DataInputStream stream) throws IOException {
//        int bytes = stream.readInt();
//        float value;
//        if(bytes == 0x7f800000) {
//            value = Float.POSITIVE_INFINITY;
//        }else if (bytes == 0xff800000){
//            value = Float.NEGATIVE_INFINITY;
//        }else if((bytes >= 0x7f800001 && bytes<=0x7ffffff ) || (bytes >= 0xff800001 && bytes<=0xffffffff)){
//            value = Float.NaN;
//        }else{
//            int s = ((bits >> 31) == 0) ? 1 : -1;
//            int e = ((bits >> 23) & 0xff);
//            int m = (e == 0) ?
//                    (bits & 0x7fffff) << 1 :
//                    (bits & 0x7fffff) | 0x800000;
//            value = s* m* (float)Math.pow(2, e-150);
//        }

        //THE ABOVE CAN BE SIMPLIFIED INTO, FOR UNDERSTANDING

        float value = stream.readFloat();

        return new Object[]{value};
    }

    @Override
    public void write(DataOutputStream stream) throws IOException {
//        int bytes;
//        if(bits == Float.POSITIVE_INFINITY){
//            bytes = 0x7f800000;
//        }else if(bits == Float.NEGATIVE_INFINITY){
//            bytes = 0xff800000;
//        }else if(Float.isNaN(bits)){
//            //bytes can be set to bytes >= 0x7f800001 && bytes<=0x7ffffff ) || (bytes >= 0xff800001 && bytes<=0xffffffff
//            bytes = 0x7f800001;
//        }else{
//            bytes = Float.floatToIntBits(bits);
//        }
//
//        stream.writeInt(bytes);

        //THE ABOVE CAN JUST BE DONE WITH
        stream.writeFloat(bits);


    }
}
