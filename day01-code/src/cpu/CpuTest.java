package cpu;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import static java.lang.Math.sin;

/**
 *让CPU占有率听你指挥
 * 把一条正弦曲线0-2PI之间的弧度等分成200份进行抽象，计算每个抽样点的振幅
 * 然后每隔300ms的时间取下一个时间点，并让CPU工作对应振幅的时间
 */
public class CpuTest {
    private static int SAMPLING_COUNT=200;//抽样点数量
    public static double PI=3.14159296;//pi值
    public static int TOTAL_AMPLITUDE=300;//每个抽样点对应的时间片
    public static void main(String[] args) {

        int[] busySpan=new int[SAMPLING_COUNT];
        int SAMPLING_COUNT=200;//抽样点数量
        double PI=3.14159296;//pi值
        int TOTAL_AMPLITUDE=300;//每个抽样点对应的时间片
        int amplitude=TOTAL_AMPLITUDE/2;
        double radian=0.0;
        double radianIncrement=2.0/(double)SAMPLING_COUNT;//抽样弧度的增量
        for(int i=0;i<SAMPLING_COUNT;i++)
        {
            busySpan[i]=(int) (amplitude+(sin(PI*radian)*amplitude));
            radian+=radianIncrement;
        }
        int startTime=0;
        for(int j=0;;j=(j+1)%SAMPLING_COUNT)
        {
            startTime=GetTickCount();
            while ((GetTickCount()-startTime)<=busySpan[j]);
            Sleep(TOTAL_AMPLITUDE-busySpan[j]);
        }
    }

    private static void Sleep(int i)
    {
    }

    private static int GetTickCount()
    {
        return 0;
    }
}

