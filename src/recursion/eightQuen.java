/**
 * 
 */
package recursion;

/**
 * @author Administrator
 *---------���ڹ��������8888888�ʺ�����-------
 */
public class eightQuen {
	static int[][] map=new int[8][8];//����  0��ʾ�����ӣ�1��ʾһ���ʺ�
	public static void main(String[] args) {
		play(0);
	}
	static int count=1;//���ڼ�����ô���
	static void show() {
		System.out.println("��"+count+"�ְڷ�");
		count++;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+"   ");
			}
			System.out.println();
		}
	}
	//-------------���Ĵ�������------------
	static void play(int row){
		//�ӵ�һ�п�ʼ������������
		for(int i=0;i<8;i++) {//����8��
			if(check(row,i)) {//��֤�Ƿ��ܹ��Żʺ�
				map[row][i]=1;//��һ���ʺ�
				
				if(row==7) {//���α�����һ��
					show();//˵���ʺ������ϣ���ʾһ��
					//map[row][i]=0;//�ںú��Ʒ������ʺ󣬼������°�
				}else {
					play(row+1);//����Լ��ķ������ý�����û�з��ûʺ���˵������һ��λ�ò���
					//map[row][i]=0;//�ϸ�λ��������Ϊ0��
					
				}
				map[row][i]=0;
			}
		}
	}
	static boolean check(int row,int col) {//�ж�ĳ�������Ƿ��лʺ�
		//����
		for(int i=row-1;i>=0;i--) {
			if(map[i][col]==1)   //��λ���Ѿ��лʺ���
				return false;
		}
		//����
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(map[i][j]==1) {
				return false;
			}
		}
		//����
		for(int i=row-1,j=col+1;i>=0&&j<8;i--,j++) {
			if(map[i][j]==1) {
				return false;
			}
		}
		return true;  //��������λ�ö�û�ûʺ�˵����λ�ÿ��Է�һ���ʺ�
	}
}
