package ruandao.exception;

public class MathTool {
	// ����-1��ʾ�������Ϸ����������Ϊ�����ǲ�����ġ�
	// ���صĽ������-1,������Ǳ�ʾ�׳˵���������
	public int fact(int i) 
			throws MyException{
		if( i<0 ) {
			//throw new MyException(this,"�����ˣ�",9);
		}
		if( i==0 )return 1;
		return i * fact( i-1);
	}
}
