package com.example.finaldoan.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.finaldoan.Models.Question;
import com.example.finaldoan.R;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private static final String DATABASE_NAME = "QuestionDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Question";

    private static final String QUESTION_ID = "id";
    private static final String CAUHOI = "Cau_hoi";
    private static final String PHANLOAI = "Phan_loai";
    private static final String SOCAUTRALOI = "So_cau_tra_loi";
    private static final String TRALOIA = "Cau_A";
    private static final String TRALOIB = "Cau_B";
    private static final String TRALOIC = "Cau_C";
    private static final String TRALOID = "Cau_D";
    private static final String DAPAN1 = "Dap_an_1";
    private static final String DAPAN2 = "Dap_an_2";
    private static final String IMAGE = "Image";

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER)", TABLE_NAME, QUESTION_ID, CAUHOI, PHANLOAI, SOCAUTRALOI, TRALOIA, TRALOIB, TRALOIC, TRALOID, DAPAN1, DAPAN2, IMAGE);
        db.execSQL(create_students_table);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question q1 = new Question(1, "Khái niệm 'đường bộ' được hiểu như thế nào là đúng?", "Ly thuyet", "3", "A. Đường bộ, cầu đường bộ.", "B. Hầm đường bộ, bến phà đường bộ.",
                "C. Đường, cầu đường bộ, hầm đường bộ, bến phà đường bộ và các công trình phụ trợ khác.", "null ", "A", "B", 0);

        Question q2 = new Question(2, "'Vạch kẻ đường' được hiểu như thế nào là đúng?", "Ly thuyet", "3", "A. Vạch kẻ đường là vạch chỉ sự phân chia làn đường, vị trí hoặc hướng đi, vị trí dừng lại.",
                "B. Vạch kẻ đường là vạch chỉ sự phân biệt trí dừng, đỗ trên đường.", "C. Tất cả các ý nêu trên.", "null", "A", "null", 0);

        Question q3 = new Question(3, "Khái niệm 'phần đường xe chạy' được hiểu như thế nào là đúng? ", "Ly thuyet", "3", "A. Là phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại.",
                "B. Là phần đường bộ được sử dụng cho các phương tiện giao thông qua lại, dải đất dọc hai bên đường để đảm bảo an toàn giao thông.",
                "C. Là phần đường bộ được sử dụng cho các phương tiện giao thông qua lại, các công trình, thiết bị phụ trợ khác và dải đất dọc hai bên đường để đảm bảo an toàn giao thông.", "null", "A", "null", 0);

        Question q4 = new Question(4, "Khái niệm 'làn đường' được hiểu như thế nào là đúng? ", "Ly thuyet", "3", "A. Là một phần của đường được chia theo chiều ngang của đường, có bề rộng đủ cho xe đỗ an toàn.",
                "B. Là một phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn. ", "C. Cả 02 ý trên.", "null", "B", "null", 0);

        Question q5 = new Question(5, "Khái niệm 'đường phố' được hiểu như thế nào là đúng? ", "Ly thuyet", "3", "A. Đường phố là đường đô thị, gồm lòng đường và hè phố.",
                "B. Đường phố là đường bộ ngoài đô thị có lòng đường đủ rộng cho các phương tiện giao thông qua lại.", "C. Cả 02 ý nêu trên.", "null", "A", "null", 0);

        Question q6 = new Question(6, "Khái niệm 'dải phân cách' được hiểu như thế nào là đúng?", "Ly thuyet", "3", "A. Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
                "B. Là bộ phận của đường để xác định ranh giới của đất dành cho người đi bộ theo chiều ngang của đường. ",
                "C. Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.", "null", "A", "null", 0);

        Question q7 = new Question(7, "Dải phân cách trên đường bộ có những loại nào? ", "Ly thuyet", "2", "A. Loại cố định.", "B. Loại di động.", "null", "null", "A", "B", 0);

        Question q8 = new Question(8, "Khái niệm 'đường ưu tiên' được hiểu như thế nào là đúng? ", "Ly thuyet", "3", "A. Đường ưu tiên là đường mà trên đó phương tiện tham gia giao thông đường bộ phải nhường đường cho các phương tiện đến từ hướng khác khi qua nơi đường giao nhau, có thể được cắm biển báo hiệu đường ưu tiên.",
                "B. Đường ưu tiên là đường mà trên đó phương tiện tham gia giao thông đường bộ được các phương tiện đến từ hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên.",
                "C. Đường ưu tiên là đường chỉ dành cho một số loại phương tiện tham gia giao thông, được cắm biển báo hiệu đường ưu tiên.", "null", "B", "null", 0);

        Question q9 = new Question(9, "'Phương tiện giao thông đường bộ' gồm những loại nào? ", "Ly thuyet", "3", "A. Phương tiện giao thông cơ giới đường bộ, phương tiện giao thông thô sơ đường bộ.",
                "B. Phương tiện giao thông thô sơ đường bộ, phương tiện giao thông cơ giới đường bộ và xe máy chuyên dùng.", "C. Cả hai ý nêu trên.", "null", "A", "null", 0);

        Question q10 = new Question(10, "Khái niệm 'phương tiện giao thông cơ giới đường bộ' được hiểu như thế nào là đúng?", "Ly thuyet", "2", "A. Gồm xe ô tô, máy kéo, xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, xe cơ giới dành cho người khuyết tật và xe máy chuyên dùng.",
                "B. Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo, xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.", "null", "null", "B", "null", 0);

        Question q11 = new Question(11, "'Phương tiện tham gia giao thông đường bộ' gồm những loại nào? ", "Ly thuyet", "2", "A. Phương tiện giao thông cơ giới đường bộ.",
                "B. Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.", "null", "null", "A", "B", 0);

        Question q12 = new Question(12, "'Người tham gia giao thông đường bộ' gồm những đối tượng nào? ", "Ly thuyet", "2", "A. Người điều khiển, người sử dụng phương tiện tham gia giao thông đường bộ.",
                "B. Người điều khiển, dẫn dắt súc vật, người đi bộ trên đường bộ.", "null", "null", "A", "B", 0);

        Question q13 = new Question(13, "Khái niệm 'người điều khiển giao thông' được hiểu như thế nào là đúng? ", "Ly thuyet", "4", "A. Là người điều khiển phương tiện tham gia giao thông.",
                "B. Là người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "C. Là cảnh sát giao thông.", "D. Tất cả các ý nêu trên.", "B", "C", 0);

        Question q14 = new Question(14, "Hành vi nào ghi ở dưới đây bị nghiêm cấm? ", "Ly thuyet", "2", "A. Phá hoại đường, cầu, hầm, bến phà đường bộ, phá hoại đèn tín hiệu, cọc tiêu, biển báo hiệu, gương cầu, dải phân cách.",
                "B. Phá hoại hệ thống thoát nước và các công trình, thiết bị khác thuộc kết cấu hạ tầng giao thông đường bộ.", "null", "null", "A", "B", 0);

        Question q15 = new Question(15, "Những hành vi nào ghi ở dưới đây bị nghiêm cấm? ", "Ly thuyet", "2", "A. Đua xe, cổ vũ đua xe, tổ chức đua xe trái phép. ",
                "B. Lạng lách, đánh võng.", "null", "null", "A", "B", 0);

        Question q16 = new Question(16, "Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không? ", "Ly thuyet", "2",
                "A. Bị nghiêm cấm.", "B. Không bị nghiêm cấm.", "null", "null", "A", "null", 0);

        Question q17 = new Question(17, "Người điều khiển xe ô tô, xe máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá bao nhiêu thì bị cấm? ", "Ly thuyet", "3",
                "A. Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng mà trong máu có nồng độ cồn vượt quá 50 miligam/100 mililit máu hoặc 0.25 miligam/1 lit khí thở.",
                "B. Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn.",
                "C. Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu có nồng độ cồn vượt quá 80 miligam/100 mililit máu hoặc 40 miligam/1 lit khí thở.", "null", "B", "null", 0);

        Question q18 = new Question(18, "Người điều khiển xe mô tô, xe gắn máy trên đường mà trong máu có nồng độ cồn vượt quá bao nhiêu thì bị cấm? ", "Ly thuyet", "3",
                "A. Nồng độ cồn vượt quá 50 miligam/100 mililit máu. ", "B. Nồng độ cồn vượt quá 40 miligam/100 mililit máu. ",
                "C. Nồng độ cồn vượt quá 30 miligam/100 mililit máu.", "null", "A", "null", 0);

        Question q19 = new Question(19, "Người điều khiển xe mô tô, xe gắn máy trên đường mà trong khí thở có nồng độ cồn vượt quá bao nhiêu thì bị cấm ? ", "Ly thuyet", "3",
                "A. Nồng độ cồn vượt quá 0.25 miligam/1 lit khí thở. ", "B. Nồng độ cồn vượt quá 0.20 miligam/1 lit khí thở. ", "C. Nồng độ cồn vượt quá 0.15 miligam/1 lit khí thở.", "null", "A", "null", 0);

        Question q20 = new Question(20, "Hành vi giao xe cơ giới, xe máy chuyên dùng cho người không đủ điều kiện để điều khiển xe tham gia giao thông có bị nghiêm cấm hay không? ", "Ly thuyet", "3",
                "A. Không bị nghiêm cấm.", "B. Bị nghiêm cấm.", "C. Bị nghiêm cấm.", "null", "B", "null", 0);
        Question q21 = new Question(21, "Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không? ", "Ly thuyet", "3",
                "A. Bị nghiêm cấm.", "B. Không bị nghiêm cấm.", "C. Bị nghiêm cấm tùy từng trường hợp.", "null", "A", "null", 0);

        Question q22 = new Question(22, "Những hành vi nào sau đây bị cấm? ", "Ly thuyet", "2", "A. Bấm còi, rú ga liên tục, bấm còi trong thời gian từ 22 giờ đến 5 giờ.",
                "B. Bấm còi hơi, sử dụng đèn chiếu xa trong khu đô thị và khu dân cư, trừ các xe ưu tiên khi đang làm nhiệm vụ.", "null", "null", "A", "B", 0);

        Question q23 = new Question(23, "Các hành vi nào sau đây bị nghiêm cấm? ", "Ly thuyet", "2", "A. Lắp đặt, sử dụng còi, đèn không đúng thiết kế của nhà sản xuất đối với từng loại xe cơ giới.",
                "B. Sử dụng thiết bị âm thanh gây mất trật tự an toàn giao thông, trật tự công cộng.", "null", "null", "A", "B", 0);

        Question q24 = new Question(24, "Hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm hoặc khi có điều kiện mà cố ý không cứu giúp người bị tai nạn giao thông có bị nghiêm cấm hay không? ", "Ly thuyet", "3",
                "A. Không bị nghiêm cấm.", "B. Nghiêm cấm tùy từng trường hợp cụ thể.", "C. Bị nghiêm cấm.", "null", "C", "null", 0);

        Question q25 = new Question(25, "Khi xảy ra tai nạn giao thông, những hành vi nào ghi ở dưới đây bị nghiêm cấm? ", "Ly thuyet", "2",
                "A. Xâm phạm tính mạng, sức khỏe, tài sản của người bị tai nạn giao thông, xâm phạm tính mạng, sức khỏe, tài sản của người gây tai nạn giao thông.",
                "B. Lợi dụng việc xảy ra tai nạn giao thông để hành hung, đe dọa, xúi giục, gây sức ép, làm mất trật tự, cản trở việc xử lý tai nạn giao thông.", "null", "null", "A", "B", 0);

        Question q26 = new Question(26, "Việc sản xuất, mua bán, sử dụng biển xe cơ giới, xe máy chuyên dùng được quy định như thế nào trong Luật giao thông đường bộ ? ", "Ly thuyet", "3",
                "A. Nghiêm cấm sản xuất, được phép sử dụng.  ", "B. Nghiêm cấm mua bán,cho phép sử dụng.", "C. Nghiêm cấm sản xuất, mua bán, sử dụng trái phép.", "null", "C", "null", 0);

        Question q27 = new Question(27, "Người lái xe không được vượt xe khác khi gặp trường hợp nào ghi ở dưới đây? ", "Ly thuyet", "2", "A. Trên cầu hẹp có một làn xe, nơi đường giao nhau, đường bộ giao nhau cùng mức với đường sắt.",
                "B. Điều kiện thời tiết hoặc đường không đảm bảo an toàn cho việc vượt, xe ưu tiên đang phát tín hiệu ưu tiên làm nhiệm vụ.", "null", "null", "A", "B", 0);

        Question q28 = new Question(28, "Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo, đẩy các xe khác, vật khác khi tham gia giao thông không? ", "Ly thuyet", "3",
                "A. Được phép.", "B. Tùy trường hợp.", "C. Không được phép.", "null", "C", "null", 0);

        Question q29 = new Question(29, "Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông không được thực hiện những hành vi nào sau đây? ", "Ly thuyet", "3",
                "A. Đội mũ bảo hiểm và cài quai đúng cách.", "B. Sử dụng ô; bấm, kéo hoặc đẩy các phương tiện khác.",
                "C. Đứng trên yên, giá đèo hàng hoặc ngồi trên tay lái, các hành vi khác gây mất trật tự an toàn giao thông.", "null", "B", "C", 0);

        Question q30 = new Question(30, "Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không? ", "Ly thuyet", "3",
                "A. Được mang, vác tùy trường hợp cụ thể. ", "B. Không được mang, vác.", "C. Được mang, vác nhưng phải đảm bảo an toàn.", "null", "B", "null", 0);


        Question q31 = new Question(31, "Khi điều khiển xe mô tô hai bánh, mô tô ba bánh, xe gắn máy những hành vi nào không được phép? ", "Ly thuyet", "3",
                "A. Buông cả hai tay hoặc đi xe bằng một bánh đối với xe hai bánh, bằng hai bánh đối với xe ba bánh, chạy quá tốc độ quy định.",
                "B. Sử dụng xe để kéo, đẩy xe khác, vật khác và chở vật cồng kềnh, để chân chống quẹt xuống đất và cá hành vi khác gây mất trật tự an toàn giao thông.",
                "C. Chạy đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.", "null", "A", "B", 0);

        Question q32 = new Question(32, "Bảo đảm trật tự an toàn giao thông đường bộ là trách nhiệm của ai? ", "Ly thuyet", "3",
                "A. Là trách nhiệm của ngành giao thông vận tải và ngành công an. ", "B. Là trách nhiệm của cơ quan, tổ chức, cá nhân.",
                "C. Là trách nhiệm của cảnh sát giao thông.", "null", "B", "null", 0);

        Question q33 = new Question(33, "Tại nơi đường giao nhau, khi đèn điều khiển giao thông có tín hiệu vàng, người điều khiển phương tiện như thế nào? ", "Ly thuyet", "3",
                "A. Phải cho xe dừng lại trước vạch dừng,trừ trường hợp đã đi quá vạch dừng thì được đi tiếp; trong trường hợp tín hiệu vàng nhấp nháy là được đi nhưng phải giảm tốc độ, chú ý quan sát, nhường đường cho người đi bộ qua đường",
                "B. Phải cho xe nhanh chóng vượt qua vạch dừng để đi qua đường giao nhau và chú ý đảm bảo an toàn; khi đèn tín hiệu vàng nhấp nháy là được đi nhưng phải giảm tốc độ, chú ý quan sát người đi bộ để đảm bảo an toàn.",
                "C. Cả 2 ý nêu trên.", "null", "A", "null", 0);

        Question q34 = new Question(34, "Biển báo hiệu đường bộ gồm những nhóm nào, ý nghĩa của từng nhóm? ", "Ly thuyet", "2", "A. Nhóm biển báo cấm để biểu thị các điều cấm; nhóm biển báo hiệu nguy hiểm để cảnh báo các tình huống nguy hiểm có thể xảy ra, nhóm biển hiệu lệnh để báo hiệu các hiệu lệnh phải thi hành.",
                "B. Nhóm biển chỉ dẫn để chỉ dẫn hướng đi hoặc các điều biết; nhóm biển phụ để thuyết minh bổ sung các loại biển báo cấm, biển báo nguy hiểm, biển hiệu lệnh và biển chỉ dẫn.",
                "null", "null", "A", "B", 0);

        Question q35 = new Question(35, "Tại nơi đường giao nhau, khi người điều khiển giao thông ra hiệu lệnh bằng hai tay hoặc một tay giang ngang để báo hiệu thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông? ", "Ly thuyet", "2",
                "A. Người tham gia giao thông ở phía trước và ở phía sau người điều khiển giao thông phải dừng lại; người tham gia giao thông ở phía bên phải và bên trái người điều khiển được đi.",
                "B. Người tham gia giao thông ở phía trước và ở phía sau người điều khiển giao thông được đi thẳng; người tham gia giao thông ở phía bên phải và bên trái người điều khiển giao thông được đi thẳng và rẽ phải.",
                "null", "null", "A", "null", 0);

        Question q36 = new Question(36, "Tại nơi đường giao nhau, khi người điều khiển giao thông ra hiệu lệnh tay giơ thẳng đứng để báo hiệu thì người tham gia giao thông phải đi như thế nào? ", "Ly thuyet", "3",
                "A. Người tham gia giao thông ở phía trước và ở phía sau người điều khiển giao thông phải dừng lại, người tham gia giao thông ở phía bên phải và bên trái người điều khiển được đi.",
                "B. Người tham gia giao thông ở các hướng phải dừng lại.", "C. Tất cả các trường hợp trên.", "null", "B", "null", 0);

        Question q37 = new Question(37, "Tại nơi đường giao nhau, khi người điều khiển giao thông ra hiệu lệnh bằng tay phải giơ về phía trước để báo hiệu thì người tham gia giao thông phải đi như thế nào? ", "Ly thuyet", "2",
                "A. Người tham gia giao thông ở phía sau người điều khiển phải dừng lại; người ở phía trước người điều khiển được rẽ trái; người ở bên trái người điều khiển được rẽ trái; người đi bộ qua đường phải dừng lại sau lưng người điều khiển giao thông.",
                "B. Người tham giao giao thông ở phía sau và bên phải người điều khiển phải dừng lại; người ở phía trước người điều khiển được rẽ phải; người ở phía bên trái người điều khiển giao thông được đi tất cả các hướng; người đi bộ qua đường phải đi sau lưng người điều khiển giao thông.",
                "null", "null", "B", "null", 0);

        Question q38 = new Question(38, "Trên đường giao thông, khi hiệu lệnh của người điều khiển giao thông trái với hiệu lệnh của đèn hoặc biển báo hiệu thì người tham gia giao thông phải chấp hành theo hiệu lệnh nào? ", "Ly thuyet", "3",
                "A. Hiệu lệnh của người điều khiển giao thông.", "B. Hiệu lệnh của đèn điều khiển giao thông.", "C. Hiệu lệnh của biển báo hiệu đường bộ.", "null", "A", "null", 0);

        Question q39 = new Question(39, "Tại nơi có biển báo hiệu cố định lại có báo hiệu tạm thời thì người tham gia giao thông phải chấp hành hiệu lệnh của báo hiệu nào?", "Ly thuyet", "2",
                "A.Biển báo hiệu cố định.", "B. Báo hiệu tạm thời.", "null", "null", "B", "null", 0);

        Question q40 = new Question(40, "Trên đường có nhiều làn đường cho xe đi cùng chiều được phân biệt bằng vạch kẻ phân làn đường, người điều khiển phương tiện phải cho xe đi như thế nào? ", "Ly thuyet", "3",
                "A. Cho xe đi trên bất kì làn đường nào,khi cần thiết phải chuyển làn đường, người lái xe phải có đèn tín hiệu báo trước và phải bảo đảm an toàn.",
                "B. Phải cho xe đi trong một làn đường và chỉ được chuyển làn đường ở những nơi cho phép; khi chuyển làn phải có tín hiệu báo trước và phải đảm bảo an toàn.",
                "C. Phải cho xe đi trong một làn, khi chuyển làn đường phải có tín hiệu báo trước, chú ý quan sát để bảo đảm an toàn.", "null", "B", "null", 0);

        Question q41 = new Question(41, "Trên đường một chiều có vạch kẻ phân làn đường, xe thô sơ và xe cơ giới phải đi như thế nào là đúng quy tắc giao thông? ", "Ly thuyet", "3",
                "A. Xe thô sơ phải đi làn đường bên trái trong cùng; xe cơ giới, xe máy chuyên dùng phải đi trên làn đường bên phải.",
                "B. Xe thô sơ phải đi trên làn đường bên phải trong cùng, xe cơ giới, xe máy chuyên dùng phải đi trên làn đường bên trái.",
                "C. Xe thô sơ phải đi trên làn đường phù hợp không gây cản trở giao thông, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.", "null", "B", "null", 0);

        Question q42 = new Question(42, "Trên đường có nhiều làn đường, người điều khiển phương tiện tham gia giao thông sử dụng làn đường như thế nào là đúng? ", "Ly thuyet", "3",
                "A. Trên đường có nhiều làn đườngcho xe đi cùng chiều được phân biêt bằng vạch kẻ phân làn đường, người điều khiển phương tiện phải cho xe đi trong một làn đường và chỉ được chuyển làn đường ở những nơi cho phép ; khi chuyển làn đường phải có tín hiệu báo trước và đảm bảo an toàn.",
                "B. Phương tiện tham gia giao thông đường bộ di chuyển tốc độ thấp hơn đi về bên trái.",
                "C. Trên đường một chiều có vạch kẻ phân làn đường, xe thô sơ phải đi trên làn đường bên phải trong cùng xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái, phương tiện tham gia giao thông đường bộ di chuyển tốc độ thấp hơn đi về bên phải.",
                "null", "A", "C", 0);

        Question q43 = new Question(43, "Xe sau có thể vượt lên bên phải xe khác đang chạy phía trước trong trường hợp nào?  ", "Ly thuyet", "3",
                "A. Khi xe phía trước có tín hiệu rẽ trái hoặc đang rẽ trái; khi xe điện đang chạy giữa đường.",
                "B. Khi xe chuyên dùng đang làm việc trên đường mà không thể vượt bên trái được.", "C. Khi có đủ khoảng trống để vượt xe.", "null", "A", "B", 0);

        Question q44 = new Question(44, "Người lái xe phải làm gì khi quay đầu xe trên cầu,gầm cầu vượt, đường ngầm hay khu vực đường bộ giao nhau cùng mức với đường sắt? ", "Ly thuyet", "3",
                "A. Không được quay đầu xe.", "B. Lợi dụng chỗ trống và phải có người làm tín hiệu sau xe để đảm bảo an toàn.",
                "C. Lợi dụng chỗ trống có thể quay đầu được để quay đầu xe cho an toàn.", "null", "A", "null", 0);

        Question q45 = new Question(45, "Khi muốn chuyển hướng, người lái xe phải thực hiện như thế nào? ", "Ly thuyet", "3", "A. Người điều khiển phương tiện phải tăng tốc độ và có tín hiệu báo hướng để rẽ.",
                "B. Người điều khiển phương tiện phải giảm tốc độ và có tín hiệu báo hướng rẽ, chỉ cho rẽ chuyển hướng khi quan sát thấy không gây trở ngại hoặc nguy hiểm cho người và phương tiện khác.",
                "C. Trong khi chuyển hướng, người lái xe, người điều khiển xe máy chuyên dùng phải nhường quyền đi trước cho người đi bộ, người đi xe đạp đang đi trên phần đường dành riêng cho họ, nhường đường cho các xe đi ngược chiều.",
                "null", "B", "C", 0);

        Question q46 = new Question(46, "Khi tránh xe đi ngược chiều, các xe phải nhường đường nhe thế nào là đúng? ", "Ly thuyet", "3",
                "A. Nơi đường hẹp chỉ đủ cho một xe chạy và có chỗ tránh xe thì xe nào ở gần chỗ tránh hơn phải vào vị trí tránh nhường đường cho xe kia đi.",
                "B. Xe xuống dốc phải nhường đường cho xe đang lên dốc, xe nào có chướng ngại vật phía trước phải nhường đường cho xe không có chướng ngại vật đi trước.",
                "C. Xe lên dốc phải nhường đường cho xe xuống dốc.", "null", "A", "B", 0);

        Question q47 = new Question(47, "Ban đêm xe cơ giới đi ngược chiều gặp nhau, đèn chiếu sáng phải sử dụng như thế nào? ", "Ly thuyet", "2",
                "A. Phải chuyến từ đèn chiếu gần sang đèn chiếu xa.", "B. Phải chuyển từ đèn chiếu xa sang đèn chiếu gần.", "null", "null", "B", "null", 0);

        Question q48 = new Question(48, "Khi có tín hiệu của xe ưu tiên, người tham gia giao thông phải làm gì? ", "Ly thuyet", "3",
                "A. Phải nhanh chống giảm tốc độ, tránh hoặc dừng lại sát lề đường bên trái để nhường đường.",
                "B. Phải nhanh chống tăng tốc độ, tránh sát lề đường để nhường đường cho xe ưu tiên. Cấm các hành vi gây cản trở xe ưu tiên.",
                "C. Phải nhanh chống giảm tốc độ, tránh hoặc dừng lại sát lề đường bên phải để nhường đường. Không được gây cản trở xe được quyền ưu tiên.", "null", "C", "null", 0);

        Question q49 = new Question(49, "Tại nơi đường giao nhau có báo hiệu đi theo vòng xuyến người điều khiển phương tiện phải nhường đường như thế nào? ", "Ly thuyet", "3",
                "A. Phải nhường đường cho xe đi bên phải.",
                "B. Xe báo hiệu xin đường trước xe đó được đi trước.", "C. Phải nhường đường cho xe đi bên trái.", "null", "C", "null", 0);

        Question q50 = new Question(50, "Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải nhường đường như thế nào? ", "Ly thuyet", "3",
                "A. Nhường đường cho xe đi ở bên phải mình tới.",
                "B. Nhường đường cho xe đi ở bên trái mình tới.",
                "C. Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính đi từ bất kì hướng nào tới.", "null", "C", "null", 0);


        Question q51 = new Question(51, "Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông? ",
                "Ly thuyet", "3", "A. Phải nhường đường cho xe đi từ bên phải. ",
                "B. Xe báo hiệu xin đường trước xe đó được đi trước. ",
                "C. Phải nhường đường cho xe đi từ bên trái.", "null", "A", "null", 0);

        Question q52 = new Question(52, "Trên đoạn đường bộ giao nhau cùng mức với đường sắt, cầu đường bộ đi chung với đường sắt thì loại phương tiện nào được quyền ưu tiên đi trước? ",
                "Ly thuyet", "3", "A. Phương tiện nào bên phải không vướng.",
                "B. Phương tiện nào ra tín hiệu xin đường trước. ",
                "C. Phương tiện giao thông đường sắt.",
                "null", "C", "null", 0);

        Question q53 = new Question(53, "Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bật sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng lại ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất? ",
                "Ly thuyet", "4", "A. 5.00m.", "B. 3.00m.", "C. 4.00m.", "C. 7.00m.", "A", "null", 0);

        Question q54 = new Question(54, " Người lái xe phải làm gì khi điều khiển xe vào đường cao tốc?",
                "Ly thuyet", "3",
                "A. Phải có tín hiệu xin vào và phải nhường đường cho xe đang chạy trên đường, khi thấy an toàn mới cho xe nhập vào dòng xe ở làn đường sát mép ngoài.",
                "B. Phải có tín hiệu và tăng tốc độ vào đường cao tốc.",
                "C. Nếu có làn đường tăng tốc thì phải cho xe chạy trên làn đường đó trước khi vào làn đường của đường cao tốc.",
                "null", "A", "C", 0);

        Question q55 = new Question(55, "Người lái xe phải làm gì khi điều khiển x era khỏi làn đường cao tốc?",
                "Ly thuyet", "2",
                "A. Phải thực hiện chuyển dần sang làn đường phía bên phải, nếu có làn đường giảm tốc thì phải cho xe chạy trên làn đường đó trước khi rời khỏi đường cao tốc.",
                "B. Phải thực hiện chuyển ngay sang các làn đường phía bên phải, nếu có làn đường giảm tốc thì phải cho xe chạy trên làn đường đó trước khi rời khỏi đường cao tốc.",
                "null", "null", "A", "null", 0);

        Question q56 = new Question(56, "Những trường hợp nào ghi ở dưới đây không được đi vào đường cao tốc trừ người, phương tiện, thiết bị phục vụ cho việc quản lí, bảo trì đường cao tốc?",
                "Ly thuyet", "3", "A. Người đi bộ, xe thô sơ, xe gắn máy và xe ô tô.",
                "B. Xe mô tô và xe máy chuyên dùng có tốc độ thiết kế lớn hơn 70km/h.",
                "C. 3-	Người đi bộ, xe thô sơ, xe gắn máy, xe mô tô và xe máy chuyên dùng có tốc độ thiết kế nhỏ hơn 70km/h.",
                "null", "C", "null", 0);

        Question q57 = new Question(57, "Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào ghi ở dưới đây?",
                "Ly thuyet", "3",
                "A. Xe cơ giới, xe máy chuyên dùng phải bật đèn, xe thô sơ phải bật đèn hoặc có vật sáng báo hiệu, chỉ được dừng xe, đỗ xe ở nơi quy định.",
                "B. Xe cơ giới phải bật đèn ngay cả khi đường hầm sáng, phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                "C. Xe máy chuyên dùng phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                "null", "A", "null", 0);

        Question q58 = new Question(58, "Người ngồi trên xe mô tô 2 bánh, xe mô tô 3 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quay đúng quy cách khi nào?",
                "Ly thuyet", "2",
                "A. Khi tham gia giao thông đường bộ. ",
                "B. Chỉ khi đi trên đường cao tốc.",
                "null",
                "null", "A", "null", 0);

        Question q59 = new Question(59, "Khi điều khiển xe mô tô 2 bánh, xe gắn máy được phép chở tối đa 2 người trong những trường hợp nào?",
                "Ly thuyet", "2",
                "A. Chở người bệnh đi cấp cứu, trẻ em dưới 14 tuổi.",
                "B. Áp giải người có hành vi vi phạm pháp luật.",
                "null",
                "null", "A", "B", 0);

        Question q60 = new Question(60, "Người điều khiển xe mô tô 2 bánh, xe mô tô 3 bánh, xe gắn máy không được thực hiện những hành vi nào ghi ở dưới đây?",
                "Ly thuyet", "3",
                "A. Đi xe dàng hàng ngang.",
                "B. Đi xe vào phần đường dành cho người đi bộ và phương tiện khác, sử dụng ô, điện thoại di động, thiết bị âm thanh( trừ thiết bị trợ thính).",
                "C. Chở người bệnh đi cấp cứu, trẻ em dưới 14 tuổi, áp giải người có hành vi vi phạm pháp luật.",
                "null", "A", "B", 0);

        Question q61 = new Question(61, "Người điều khiển, người ngồi trên xe đạp máy phải đội mũ bảo hiểm có cài quay đúng quy cách khi nào?",
                "Ly thuyet", "2",
                "A. Khi tham gia giao thông đường bộ.",
                "B. Chỉ khi tham gia giao thông trên đường quốc lộ, khu vực đô thị.",
                "null",
                "null", "A", "null", 0);

        Question q62 = new Question(62, "Cơ quan nào quy định các đoạn đường cấm đi, đường đi một chiều, nơi cấm dừng, cấm đỗ, cấm quay đầu xe, lắp đặt báo hiệu đường bộ thuộc địa phương quản lí?",
                "Ly thuyet", "4",
                "A. Cơ quan quản lý giao thông vận tải. ",
                "B. Uỷ ban nhân dân cấp tỉnh.",
                "C. Cơ quan cảnh sát giao thông đường bộ",
                "D. Thanh tra giao thông đường bộ.",
                "B", "null", 0);

        Question q64 = new Question(64, "Những người có mặt tại nơi xảy ra tai nạn giao thông có trách nhiệm gì?",
                "Ly thuyet", "2",
                "A. Bảo vệ hiện trường, giúp đỡ, cứu chữa người bị nạn, bảo vệ tài sản của người bị nạn.",
                "B. Báo tin ngay cho cơ quan công an, y tế hoặc Uỷ ban nhân dân nơi gần nhất, cung cấp thông tin xác thực về vụ tai nạn theo yêu cầu của cơ quan có thẩm quyền.",
                "null",
                "A", "B", "null", 0);

        Question q63 = new Question(63, "Người điều khiển phương tiện và những người liên quan trực tiếp đến vụ tai nạn có trách nhiệm gì?",
                "Ly thuyet", "3",
                "A. Dừng ngay phương tiện, giữ nguyên hiện trường, cấp cứu người bị nạn và phải có mặt khi cơ quan có thẩm quyền yêu cầu, cung cấp thông tin xác thực về vụ tai nạn cho cơ quan có thẩm quyền.",
                "B. Ở lại nơi xảy ra tai nạn cho đến khi người của cơ quan công an đến, trừ trường hợp người điều khiển phương tiện cũng bị thương phải đưa đi cấp cứu hoặc phải đưa người bị nạn đi cấp cứu hoặc vì lý do đe dọa đến tính mạng nhưng phải đến trình báo ngay với cơ quan công an gần nhất.",
                "C. Rời khỏi hiện trường nơi xảy ra tai nạn giao thông.",
                "null", "A", "B", 0);

        Question q65 = new Question(65, "Khi điều khiển xe chạy trên đường, người lái xe phải mang theo các loại giấy tờ gì?",
                "Ly thuyet", "3",
                "A. Giấy phép lái xe, đăng kí xe, giấy phép lưu hành xe. ",
                "B. Lệnh vận chuyển, đăng kí xe, giấy phép lưu hành xe.",
                "C. Giấy phép lái xe phù hợp với loại xe đó, đăng kí xe, giấy chứng nhận kiểm định kĩ thuật và bảo vệ môi trường, giấy chứng nhận trách nhiệm bảo hiểm trách nhiệm dân sự của chủ xe cơ giới và giấy phép vận chuyển (nếu loại xe đó cần phải có).",
                "null", "C", "null", 0);

        Question q66 = new Question(66, "Người đủ bao nhiêu tuổi trở lên thì được điều khiển xe mô tô 2 bánh, xe mô tô 3 bánh có dung tích xilanh từ 50 cm3 trở lên và các loại xe có kết cấu tương tự, xe ô tô tải, máy kéo có trọng tải dưới 3,5 tấn; xe ô tô chở người dưới 9 chỗ ngồi?",
                "Ly thuyet", "3",
                "A. 16 tuổi",
                "B. 18 tuổi",
                "C. 17 tuổi",
                "null", "B", "null", 0);

        Question q68 = new Question(68, "Người đủ 16 tuổi được điều khiển các loại xe nào dưới đây?",
                "Ly thuyet", "4",
                "A. Xe mô tô hai bánh có dung tích xilanh từ 50 cm3 trở lên.  ",
                "B. Xe gắn máy có dung tích xilanh từ 50 cm3 trở xuống.",
                "C. Xe ô tô tải dưới 3,5 tấn, xe chở người đến 9 chỗ ngồi",
                "D. Tất cả các ý trên.",
                "B", "null", 0);

        Question q67 = new Question(67, "Tại ngã ba hoặc ngã tư không có đảo an toàn, người lái xe phải nhường đường như thế nào là đúng trong các trường hợp dưới đây?",
                "Ly thuyet", "3",
                "A. Nhường đường cho xe đi trên đường nhánh từ bất kỳ hướng nào tới.",
                "B. Nhường đường cho người đi bộ đang đi trên phần đường dành cho người đi bộ sang đường.",
                "C. Nhường đường cho xe đi trên đường ưu tiên, đường chính đi từ bất kì hướng nào tới, nhường đường cho xe ưu tiên, nhường đường cho xe đi từ bên phải đến.",
                "null", "B", "C", 0);

        Question q69 = new Question(69, "Khi phát hiện hành vi giả khai báo mất hoặc tẩy xóa, làm sai lệch các thông tin trên giấy phép lái xe; sử dụng giấy phép lái xe hoặc đổi hồ sơ giả; có hành vi cố tình gian dối để được đổi, cấp mới, cấp lại giấy phép lái xe, ngoài việc bị cơ quan quản lý giấy phép lái xe quyết định thu hồi giấy phép lái xe và hồ sơ gốc còn phải chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm?",
                "Ly thuyet", "3",
                "A. 05 năm.",
                "B. 03 năm.",
                "C. 02 năm.",
                "null", "A", "null", 0);

        Question q70 = new Question(70, "Người lái xe mô tô xử lý như thế nào khi cho xe mô tô phía sau vượt? ",
                "Ly thuyet", "3",
                "A. Lái xe vào lề đường bên phải và giảm tốc độ để xe phía sau vượt qua.",
                "B. Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua. ",
                "C. Lái xe vào lề đường bên phải và tăng tốc độ để xe phía sau vượt qua.",
                "null", "A", "null", 0);


        Question q71 = new Question(71, "Trong các trường hợp dưới đây, để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào?",
                "Ly thuyet", "4",
                "A. Phải đội mũ bảo hiểm có cài quay đúng quy cách, mặc quần áo gọn gàng.",
                "B. Không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính). ",
                "C. Buông cả hai tay hoặc đi xe bằng 1 bánh.",
                "D. Tất cả các ý nêu trên.", "A", "B", 0);

        Question q72 = new Question(72, "Đường bộ trong khu vực đông dân cư gồm những đường nào?",
                "Ly thuyet", "3",
                "A. Đường bộ nằm trong khu vực nội thành phố, nội thị xã, nội thị trấn, khu công nghiệp có đông người và phương tiện tham gia giao thông.",
                "B. Đường bộ nằm trong khu vực nội thành phố, nội thị xã và những đoạn đường bộ được xác định từ vị trí có hiệu lực của biển báo hiệu “bắt đầu khu đông dân cư” đến vị trí có hiệu lực của biển báo hiệu “hết khu đông dân cư”.",
                "C. Đường bộ có đông người, phương tiện tham gia giao thông và những đoạn đường bộ được xác định từ vị trí có hiệu lực của biển báo hiệu “bắt đầu khu đông dân cư” đến vị trí có hiệu lực của biển báo hiệu “hết khu đông dân cư”.",
                "null", "B", "null", 0);

        Question q73 = new Question(73, "Trên đường bộ trong khu vực đông dân cư, xe mô tô hai bánh, xe gắn máy tham gia giao thông với tốc độ tối đa cho phép là bao nhiêu?",
                "Ly thuyet", "4",
                "A. 60 km/h.",
                "B. 50 km/h.",
                "C. 40 km/h.",
                "D. 30 km/h.", "C", "null", 0);

        Question q74 = new Question(74, "Trên đường bộ trong khu vực đông dân cư, loại xe nào tham gia giao thông với tốc độ tối đa cho phép là 40 km/h?",
                "Ly thuyet", "3",
                "A. Ô tô chở người trên 30 chỗ ngồi, ô tô tải có trọng tải từ 3500kg trở lên, ô tô sơ mi rơ mooc, ô tô kéo rơ moóc, ô tô kéo xe khác, ô tô chuyên dùng, xe mô tô, xe gắn máy.",
                "B. Ô tô chở người đến 30 chỗ ngồi, ô tô tải có trọng tải dưới 3500 kg.",
                "C. Xe máy kéo, xe công nông, xe lam, xe lôi máy xe xích lô máy, xe ba gác máy, xe máy chuyên dùng và các loại xe tương tự (loại đang được phép hoạt động).",
                "null", "A", "null", 0);

        Question q75 = new Question(75, "Trên đường bộ ngoài khu đông dân cư, loại xe nào tham gia giao thông với tốc độ tối đa cho phép là 50 km/h?",
                "Ly thuyet", "4",
                "A. Ô tô chở người đến 30 chỗ ngồi ( trừ ô tô buýt), ô tô tải có tải trọng dưới 3500 kg. ",
                "B. Ô tô chở người trên 30 chỗ ngồi ( trừ ô tô buýt), ô tô tải có trọng tải dưới 3500 kg. ",
                "C. Ô tô kéo rơ moóc, ô tô kéo xe khác, xe gắn máy.",
                "D. Ô tô buýt, ô tô sơ mi rơ moóc, ô tô chuyên dùng, xe mô tô.", "C", "null", 0);

        Question q76 = new Question(76, "Khái niệm về văn hóa giao thông được hiểu như thế nào là đúng?",
                "Ly thuyet", "2",
                "A. Là sự hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông, là ý thức trách nhiệm với cộng đồng khi tham gia giao thông.",
                "B. Là ứng xử văn hóa có tình yêu thương con người trong các tình huống không may xảy ra khi tham gia giao thông.",
                "null",
                "null", "A", "B", 0);

        Question q77 = new Question(77, "Người lái xe cố tình vi phạm Luật giao thông đường bộ, không phân biệt làn đường, vạch phân làn, phóng nhanh, vượt ẩu, vượt đèn đỏ, đi vào đường cấm, đường một chiều được coi là hành vi nào trong các hành vi sau đây?",
                "Ly thuyet", "3",
                "A. Là bình thường.",
                "B. Là thiếu văn hóa giao thông. ",
                "C. Là có văn hóa giao thông.",
                "null", "B", "null", 0);

        Question q78 = new Question(78, "Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "Ly thuyet", "4",
                "A. Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông, đội mũ bảo hiểm ở những nơi có biển báo bắt buộc đội mũ bảo hiểm.",
                "B. Chấp hành quy định về tốc độ, đèn tín hiệu, biển báo hiệu, vạch kẻ đường khi lái xe.",
                "C. Chấp hành hiệu lệnh, chỉ dẫn của người điều khiển giao thông, nhường đường cho người đi bộ, người già, trẻ em, người khuyết tật.",
                "D. Cả 3 ý nêu trên.", "B", "C", 0);

        Question q79 = new Question(79, "Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "Ly thuyet", "4",
                "A. Điều khiển xe đi bên phải chiều đi của mình.",
                "B. Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông.  ",
                "C. Đi đúng phần đường, làn đường quy định; đội mũ bảo hiểm đúng quy cách.",
                "D. Đội mũ bảo hiểm ở nơi có biển báo bắt buộc đội mũ bảo hiểm.", "A", "C", 0);

        Question q80 = new Question(80, "Người có văn hóa giao thông, khi điều khiển xe cơ giới tham gia giao thông đường bộ phải đảm bảo các điều kiện gì?",
                "Ly thuyet", "2",
                "A. Có giấy phép lái xe phù hợp với loại xe được phép điều khiển, xe cơ giới đảm bảo các quy định về chất lượng, an toàn kỹ thuật và bảo vệ môi trường.",
                "B. Có giấy chứng nhận trách nhiệm bảo hiểm dân sự của chủ xe cơ giới còn hiệu lực, nộp phí sử dụng đường bộ theo quy định.",
                "null",
                "null", "A", "C", 0);


        Question q81 = new Question(81, "Biển nào cấm người đi bộ?", "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 1 và 3.",
                "C. Biển 2.",
                "D. Biển 2 và 3.", "C", "null", R.drawable.hinh81);

        Question q82 = new Question(82, "Gặp biển nào người lái xe phải nhường đường cho người đi bộ?",
                "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 3.",
                "C. Biển 2.",
                "D. Biển 2 và 3.", "A", "null", R.drawable.hinh82);

        Question q83 = new Question(83, "Biển nào chỉ đường dành cho người đi bộ, các loại xe không được đi vào khi gặp biển này?",
                "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 1 và 3.",
                "C. Biển 3.",
                "D. Cả ba biển.", "C", "null", R.drawable.hinh83);

        Question q84 = new Question(84, "Biển nào báo hiệu sắp đến chỗ giao nhau nguy hiểm?", "Bien bao", "4",
                "A. Biển 1 và 2.",
                "B. Biển 2 và 3.",
                "C. Biển 1.",
                "D. Cả ba biển.", "B", "null", R.drawable.hinh84);

        Question q85 = new Question(85, "Biển nào báo hiệu sắp đến chỗ giao nhau với đường sắt có rào chắn?", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2 và 3.",
                "C. Biển 3.",
                "null", "A", "null", R.drawable.hinh85);

        Question q86 = new Question(86, "Biển nào báo hiệu giao nhau có tín hiệu đèn?", "Bien bao", "4",
                "A. Biển 2.",
                "B. Biển 1.",
                "C. Biển 3.",
                "D. Cả ba biển.", "C", "null", R.drawable.hinh86);

        Question q87 = new Question(87, "Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?", "Bien bao", "4",
                "A. Biển 1 và 3.",
                "B. Biển 1 và 2.",
                "C. Biển 2 và 3.",
                "D. Cả ba biển.", "A", "null", R.drawable.hinh87);

        Question q88 = new Question(88, "Biển nào báo hiệu đường sắt giao nhau với đường bộ không có rào chắn?", "Bien bao", "3",
                "A. Biển 1 và 2.",
                "B. Biển 2 và 3.",
                "C. Biển 1 và 3. ",
                "null", "B", "null", R.drawable.hinh88);

        Question q89 = new Question(89, " Biển nào báo hiệu 'Hết đoạn đường ưu tiên'?", "Bien bao", "3",
                "A. Biển 3.",
                "B. Biển 1.",
                "C. Biển 2.",
                "null", "A", "null", R.drawable.hinh89);

        Question q90 = new Question(90, "Biển nào báo hiệu, chỉ dẫn xe đi trên đường này được quyền ưu tiên qua nơi giao nhau?", "Bien bao", "4",
                "A. Biển 1 và 2.",
                "B. Biển 1 và 3.",
                "C. Cả ba biển.",
                "D. Biển 2 và 3.", "B", "null", R.drawable.hinh90);


        Question q91 = new Question(91, "Biển nào báo hiệu giao nhau với đường không ưu tiên? ", "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 2 và 3.",
                "C. Biển 2.",
                "D. Biển 3.", "A", "null", R.drawable.hinh91);

        Question q92 = new Question(92, "Biển nào báo hiệu giao nhau với đường ưu tiên? ", "Bien bao", "3",
                "A. Biển 1 và 3.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "B", "null", R.drawable.hinh92);

        Question q93 = new Question(93, "Biển nào báo hiệu giao nhau với đường ưu tiên? ", "Bien bao", "3",
                "A. Biển 1 và 3.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "B", "null", R.drawable.hinh93);

        Question q94 = new Question(94, "Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 3.",
                "C. Biển 2.",
                "null", "A", "null", R.drawable.hinh94);

        Question q95 = new Question(95, "Biển nào báo hiệu giao nhau với đường không ưu tiên? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "B", "null", R.drawable.hinh95);

        Question q96 = new Question(96, "Biển nào báo hiệu đường hai chiều? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "A", "null", R.drawable.hinh96);

        Question q97 = new Question(97, "Biển nào báo hiệu phải giảm tốc độ, nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "B", "null", R.drawable.hinh97);

        Question q98 = new Question(98, "Biển nào chỉ dẫn được ưu tiên qua đường hẹp? ", "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "D. Biển 2 và 3.", "C", "null", R.drawable.hinh98);

        Question q99 = new Question(99, "Biển nào báo hiệu cấm xe mô tô ba bánh đi vào? ", "Bien bao", "3",
                "A. Biển 1 và 3.",
                "B. Biển 1 và 2.",
                "C. Biển 2 và 3.",
                "null", "B", "null", R.drawable.hinh99);

        Question q100 = new Question(100, "Biển nào báo hiệu cấm xe mô tô hai bánh đi vào? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "A", "null", R.drawable.hinh100);
        Question q101 = new Question(101, "Khai gặp biển nào thì xe mô tô hai bánh được đi vào? ", "Bien bao", "4",
                "A. Không biển nào.",
                "B. Biển 1 và 2.",
                "C. Biển 2 và 3.",
                "D. Cả ba biển.", "C", "null", R.drawable.hinh101);

        Question q102 = new Question(102, "Biển nào xe mô tô hai bánh được đi vào? ", "Bien bao", "3",
                "A. Biển 1 và 2.",
                "B. Biển 1 và 3.",
                "C. Biển 2 và 3.",
                "null", "B", "null", R.drawable.hinh102);

        Question q103 = new Question(103, "Biển nào xe mô tô hai bánh không được đi vào? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "null", "B", "null", R.drawable.hinh103);

        Question q104 = new Question(104, "Ba biển này có ý nghĩa hiệu lực như thế nào? ", "Bien bao", "2",
                "A. Cấm các loại xe ở biển phụ đi vào.",
                "B. Cấm các loại xe cơ giới đi vào trừ loại xe ở biển phụ.",
                "null",
                "null", "A", "null", R.drawable.hinh104);

        Question q105 = new Question(105, "Biển nào cấm quay xe? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Không biển nào.",
                "null", "A", "B", R.drawable.hinh105);

        Question q106 = new Question(106, "Biển nào cấm xe rẽ trái ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Cả hai biển.",
                "null", "A", "null", R.drawable.hinh106);

        Question q107 = new Question(107, "Khi gặp biển nào xe được rẽ trái? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Không biển nào.",
                "null", "B", "null", R.drawable.hinh107);

        Question q108 = new Question(108, "Khi gặp biển nào xe ưu tiên theo luật định vẫn phải dừng lại? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Cả hai biển.",
                "null", "B", "null", R.drawable.hinh108);

        Question q109 = new Question(109, "Khi đến chỗ giao nhau, gặp biển nào thì người lái xe không được cho xe đi thẳng, phải rẽ sang hướng khác? ", "Bien bao", "4",
                "A. Biển 1 và 3.",
                "B. Biển 2 và 3.",
                "C. Biển 1 và 2.",
                "D. Cả hai biển.", "C", "null", R.drawable.hinh109);

        Question q110 = new Question(110, "Khi gặp biển này, xe lam và mô tô ba bánh có được phép rẽ trái hay rẽ phải hay không? ", "Bien bao", "2",
                "A. Được phép.",
                "B. Không được phép.",
                "null",
                "null", "B", "null", R.drawable.hinh110);


        Question q111 = new Question(111, "Biển này có hiệu lực đối với xe mô tô hai, ba bánh không? ", "Bien bao", "2",
                "A. Có.",
                "B. Không.",
                "null",
                "null", "A", "null", R.drawable.hinh111);

        Question q112 = new Question(112, "Biển nào báo hiệu cầu vượt liên thông? ", "Bien bao", "4",
                "A. Biển 2 và 3.",
                "B. Biển 1 và 2.",
                "C. Biển 1 và 3.",
                "D. Cả ba biển.", "C", "null", R.drawable.hinh112);

        Question q113 = new Question(113, "Biển nào báo hiệu đoạn đường hay xảy ra tai nạn? ", "Bien bao", "3",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 2 và 3.",
                "null", "B", "null", R.drawable.hinh113);

        Question q114 = new Question(114, "Biển nào báo hiệu tuyến đường cầu vượt cắt qua? ", "Bien bao", "3",
                "A. Biển 1 và 2.",
                "B. Biển 1 và 3.",
                "C. Biển 2 và 3.",
                "null", "A", "null", R.drawable.hinh114);

        Question q115 = new Question(115, "Biển nào chỉ dẫn tên đường trên các tuyến đường đối ngoại? ", "Bien bao", "4",
                "A. Biển 1.",
                "B. Biển 2.",
                "C. Biển 3.",
                "D. Biển 1 và 2.", "C", "null", R.drawable.hinh115);


        Question q116 = new Question(116, "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe tải, xe lam, xe con, mô tô. ",
                "B. Xe tải, mô tô, xe lam, xe con. ",
                "C.  Xe lam, xe tải, xe con, mô tô. ",
                "D. Mô tô, xe lam, xe tải, xe con.", "B", "null", R.drawable.hinh116);

        Question q117 = new Question(117, "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe tải, xe lam, mô tô. ",
                "B. Xe lam, xe tải, mô tô. ",
                "C. Mô tô, xe lam, xe tải. ",
                "D. Xe lam, mô tô, xe tải.", "C", "null", R.drawable.hinh117);

        Question q118 = new Question(118, "Trường hợp này xe nào được quyền đi trước? ", "Sa hinh", "2",
                "A. Mô tô.",
                "B. Xe con.",
                "null",
                "null", "B", "null", R.drawable.hinh118);

        Question q119 = new Question(119, "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe lam, xe cứu thương, xe con. ",
                "B. Xe cứu thương, xe con, xe lam. ",
                "C. Xe con, xe lam, xe cứu thương.",
                "null", "A", "null", R.drawable.hinh119);

        Question q120 = new Question(120, "Xe nào được quyền đi trước trong trường hợp này? ", "Sa hinh", "2",
                "A. Mô tô.",
                "B. Xe cứu thương.",
                "null",
                "null", "B", "null", R.drawable.hinh120);


        Question q121 = new Question(121, "Theo tín hiệu đèn, xe nào được phép đi? ", "Sa hinh", "2",
                "A. Xe con và xe khách.",
                "B. Mô tô.",
                "null",
                "null", "A", "null", R.drawable.hinh121);

        Question q122 = new Question(122, "Theo tín hiệu đèn, xe nào được quyền đi là đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe khách, mô tô.",
                "B. Xe tải, mô tô.",
                "C. Xe con, xe tải.",
                "null", "C", "null", R.drawable.hinh122);

        Question q123 = new Question(123, "Các xe đi theo mũi tên, xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe khách, xe tải, mô tô. ",
                "B. Xe tải, xe con, mô tô.",
                "C. Xe khách, xe con, mô tô.",
                "null", "A", "null", R.drawable.hinh123);

        Question q124 = new Question(124, "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe khách, xe tải, mô tô, xe con. ",
                "B. Xe con, xe khách, xe tải, mô tô. ",
                "C. Mô tô, xe tải, xe khách, xe con. ",
                "D. Mô tô, xe tải, xe con, xe khách.", "C", "null", R.drawable.hinh124);

        Question q125 = new Question(125, "Trong trường hợp này xe nào đỗ vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe tải.",
                "B. Xe con và mô tô.",
                "C. Cả ba xe.",
                "D. Xe con và xe tải.", "A", "null", R.drawable.hinh125);

        Question q126 = new Question(126, "Xe nào được quyền đi trước? ", "Sa hinh", "3",
                "A. Xe tải.",
                "B. Xe con.",
                "C. Xe lam.",
                "null", "B", "null", R.drawable.hinh126);

        Question q127 = new Question(127, "Theo mũi tên, những hướng nào xe gắn máy đi được? ", "Sa hinh", "3",
                "A. Cả ba hướng. ",
                "B. Hướng 1 và 3.",
                "C. Chỉ hướng 1.",
                "null", "A", "null", R.drawable.hinh127);

        Question q128 = new Question(128, "Xe nào đỗ vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Cả hai xe.",
                "B. Không xe nào vi phạm.",
                "C. Chỉ xe mô tô vi phạm.",
                "D. Chỉ xe tải vi phạm.", "A", "null", R.drawable.hinh128);

        Question q129 = new Question(129, "Xe nào đỗ vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Mô tô.",
                "B. Xe tải.",
                "C. Cả ba xe.",
                "D. Mô tô và xe tải.", "C", "null", R.drawable.hinh129);

        Question q130 = new Question(130, "Xe tải kéo mô tô ba bánh như hình này có đúng quy tắc giao thông không? ", "Sa hinh", "2",
                "A. Đúng.",
                "B. Không đúng.",
                "null",
                "null", "B", "null", R.drawable.hinh130);

        Question q131 = new Question(131, "Xe nào được quyền đi trước trong trường hợp này? ", "Sa hinh", "2",
                "A. Xe lam.",
                "B. Xe xích lô.",
                "null",
                "null", "B", "null", R.drawable.hinh131);

        Question q132 = new Question(132, "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe lam, mô tô, xe con, xe đạp. ",
                "B. Xe con, xe đạp, mô tô, xe lam. ",
                "C. Xe lam, xe con, mô tô + xe đạp. ",
                "D. Mô tô + xe đạp, xe lam, xe con.", "D", "null", R.drawable.hinh132);

        Question q133 = new Question(133, "Xe nào được quyền đi trước trong trường hợp này? ", "Sa hinh", "2",
                "A. Mô tô.",
                "B. Xe con.",
                "null",
                "null", "A", "null", R.drawable.hinh133);

        Question q134 = new Question(134, "Xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe khách.",
                "B. Mô tô.",
                "C. Xe con.",
                "D. Xe con và mô tô.", "C", "null", R.drawable.hinh134);

        Question q135 = new Question(135, "Các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Các xe ở phía tay phải và tay trái của người điều khiển được phép đi thẳng. ",
                "B. Cho phép các xe ở mọi hướng được rẽ phải.",
                "C. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                "null", "C", "null", R.drawable.hinh135);

        Question q136 = new Question(136, "Theo hướng mũi tên, xe nào được phép đi? ", "Sa hinh", "4",
                "A. Mô tô, xe con.",
                "B. Xe con, xe tải.",
                "C. Mô tô, xe tải.",
                "D. Cả ba xe.", "C", "null", R.drawable.hinh136);

        Question q137 = new Question(137, "Trong hình dưới đây, xe nào chấp hành đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe khách, mô tô.",
                "B. Tất cả các loại xe trên.",
                "C. Không xe nào chấp hành đúng quy tắc giao thông.",
                "null", "B", "null", R.drawable.hinh137);

        Question q138 = new Question(138, "Theo hướng mũi tên, những hướng nào xe mô tô được phép đi. ", "Sa hinh", "4",
                "A. Cả ba hướng.",
                "B. Hướng1 và 2.",
                "C. Hướng 1 và 3.",
                "D. Hướng 2 và 3.", "C", "null", R.drawable.hinh138);

        Question q139 = new Question(139, "Trong trường hợp này, thứ tự các xe đi như thế nào là đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe công an, xe quân sự, xe con + mô tô. ",
                "B. Xe quân sự, xe công an, xe con + mô tô.",
                "C. Xe mô tô + xe con, xe quân sự, xe công an.",
                "null", "B", "null", R.drawable.hinh139);

        Question q140 = new Question(140, "Trong hình dưới, những xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe con (E), mô tô (C).",
                "B. Xe tải (A), mô tô (D).",
                "C. Xe khách (B), mô tô (C).",
                "D. Xe khách (B), mô tô (D).", "A", "null", R.drawable.hinh140);

        Question q141 = new Question(141, "Trong hình dưới, những xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe con (B), mô tô (C).",
                "B. Xe con (A), mô tô (C).",
                "C. Xe con (E), mô tô (D). ",
                "D. Xe con (E), mô tô (D). Tất cả các loại xe trên.", "C", "null", R.drawable.hinh141);

        Question q142 = new Question(142, "Theo tín hiệu đèn, xe nào phải dừng lại là đúng quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe khách, mô tô.",
                "B. Xe tải, mô tô.",
                "C. Xe con, xe tải.",
                "null", "C", "null", R.drawable.hinh142);

        Question q143 = new Question(143, "Bạn có được phép vượt xe mô tô phía trước không? ", "Sa hinh", "2",
                "A. Cho phép.",
                "B. Không được vượt.",
                "null ",
                "null", "B", "null", R.drawable.hinh143);

        Question q144 = new Question(144, "Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe mô tô.",
                "B. Xe ô tô con.",
                "C. Không xe nào vi phạm.",
                "null", "A", "B", R.drawable.hinh144);

        Question q145 = new Question(145, "Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe con.",
                "B. Xe tải.",
                "C. Xe con, xe tải.",
                "null", "B", "null", R.drawable.hinh145);

        Question q146 = new Question(146, "Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "3",
                "A. Xe tải, xe con.",
                "B. Xe khách, xe con.",
                "C. Xe khách, xe tải.",
                "null", "C", "null", R.drawable.hinh146);

        Question q147 = new Question(147, "Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe con, xe tải, xe khách.",
                "B. Xe tải, xe khách, xe mô tô. ",
                "C. Xe khách, xe mô tô, xe con. ",
                "D. Cả bốn xe.", "B", "null", R.drawable.hinh147);

        Question q148 = new Question(148, "Các xe đi theo hướng mũi tên, xe nào chấp hành đúng quy tắc giao thông? ", "Sa hinh", "4",
                "A. Xe tải, mô tô.",
                "B. Xe khách, mô tô.",
                "C. Xe tải, xe con.",
                "D. Mô tô, xe con.", "B", "null", R.drawable.hinh148);

        Question q149 = new Question(149, "Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ? ", "Sa hinh", "3",
                "A. Xe của bạn, mô tô, xe con. ",
                "B. Xe con, xe của bạn, mô tô. ",
                "C. Mô tô, xe con, xe của bạn.",
                "null", "C", "null", R.drawable.hinh149);

        Question q150 = new Question(150, "Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ? ", "Sa hinh", "3",
                "A. Xe của bạn, mô tô, xe con. ",
                "B. Xe con, xe của bạn, mô tô. ",
                "C. Mô tô, xe con, xe của bạn.",
                "null", "B", "null", R.drawable.hinh150);


        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);
        addQuestion(q11);
        addQuestion(q12);
        addQuestion(q13);
        addQuestion(q14);
        addQuestion(q15);
        addQuestion(q16);
        addQuestion(q17);
        addQuestion(q18);
        addQuestion(q19);
        addQuestion(q20);
        addQuestion(q21);
        addQuestion(q22);
        addQuestion(q23);
        addQuestion(q24);
        addQuestion(q25);
        addQuestion(q26);
        addQuestion(q27);
        addQuestion(q28);
        addQuestion(q29);
        addQuestion(q30);
        addQuestion(q31);
        addQuestion(q32);
        addQuestion(q33);
        addQuestion(q34);
        addQuestion(q35);
        addQuestion(q36);
        addQuestion(q37);
        addQuestion(q38);
        addQuestion(q39);
        addQuestion(q40);
        addQuestion(q41);
        addQuestion(q42);
        addQuestion(q43);
        addQuestion(q44);
        addQuestion(q45);
        addQuestion(q46);
        addQuestion(q47);
        addQuestion(q48);
        addQuestion(q49);
        addQuestion(q50);
        addQuestion(q51);
        addQuestion(q52);
        addQuestion(q53);
        addQuestion(q54);
        addQuestion(q55);
        addQuestion(q56);
        addQuestion(q57);
        addQuestion(q58);
        addQuestion(q59);
        addQuestion(q60);
        addQuestion(q61);
        addQuestion(q62);
        addQuestion(q63);
        addQuestion(q64);
        addQuestion(q65);
        addQuestion(q66);
        addQuestion(q67);
        addQuestion(q68);
        addQuestion(q69);
        addQuestion(q70);
        addQuestion(q71);
        addQuestion(q72);
        addQuestion(q73);
        addQuestion(q74);
        addQuestion(q75);
        addQuestion(q76);
        addQuestion(q77);
        addQuestion(q78);
        addQuestion(q79);
        addQuestion(q80);
        addQuestion(q81);
        addQuestion(q82);
        addQuestion(q83);
        addQuestion(q84);
        addQuestion(q85);
        addQuestion(q86);
        addQuestion(q87);
        addQuestion(q88);
        addQuestion(q89);
        addQuestion(q90);
        addQuestion(q91);
        addQuestion(q92);
        addQuestion(q93);
        addQuestion(q94);
        addQuestion(q95);
        addQuestion(q96);
        addQuestion(q97);
        addQuestion(q98);
        addQuestion(q99);
        addQuestion(q100);
        addQuestion(q101);
        addQuestion(q102);
        addQuestion(q103);
        addQuestion(q104);
        addQuestion(q105);
        addQuestion(q106);
        addQuestion(q107);
        addQuestion(q108);
        addQuestion(q109);
        addQuestion(q110);
        addQuestion(q111);
        addQuestion(q112);
        addQuestion(q113);
        addQuestion(q114);
        addQuestion(q115);
        addQuestion(q116);
        addQuestion(q117);
        addQuestion(q118);
        addQuestion(q119);
        addQuestion(q120);
        addQuestion(q121);
        addQuestion(q122);
        addQuestion(q123);
        addQuestion(q124);
        addQuestion(q125);
        addQuestion(q126);
        addQuestion(q127);
        addQuestion(q128);
        addQuestion(q129);
        addQuestion(q130);
        addQuestion(q131);
        addQuestion(q132);
        addQuestion(q133);
        addQuestion(q134);
        addQuestion(q135);
        addQuestion(q136);
        addQuestion(q137);
        addQuestion(q138);
        addQuestion(q139);
        addQuestion(q140);
        addQuestion(q141);
        addQuestion(q142);
        addQuestion(q143);
        addQuestion(q144);
        addQuestion(q145);
        addQuestion(q146);
        addQuestion(q147);
        addQuestion(q148);
        addQuestion(q149);
        addQuestion(q150);
    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(CAUHOI, question.getCau_hoi());
        cv.put(PHANLOAI, question.getPhan_loai());
        cv.put(SOCAUTRALOI, question.getSo_cau_tra_loi());
        cv.put(TRALOIA, question.getCau_A());
        cv.put(TRALOIB, question.getCau_B());
        cv.put(TRALOIC, question.getCau_C());
        cv.put(TRALOID, question.getCau_D());
        cv.put(DAPAN1, question.getDap_an_1());
        cv.put(DAPAN2, question.getDap_an_2());
        cv.put(IMAGE, question.getImage());
        db.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setCau_hoi(c.getString(c.getColumnIndex(CAUHOI)));
                question.setPhan_loai(c.getString(c.getColumnIndex(PHANLOAI)));
                question.setSo_cau_tra_loi(c.getString(c.getColumnIndex(SOCAUTRALOI)));
                question.setCau_A(c.getString(c.getColumnIndex(TRALOIA)));
                question.setCau_B(c.getString(c.getColumnIndex(TRALOIB)));
                question.setCau_C(c.getString(c.getColumnIndex(TRALOIC)));
                question.setCau_D(c.getString(c.getColumnIndex(TRALOID)));
                question.setDap_an_1(c.getString(c.getColumnIndex(DAPAN1)));
                question.setDap_an_2(c.getString(c.getColumnIndex(DAPAN2)));
                question.setImage(c.getInt(c.getColumnIndex(IMAGE)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getKhaiNiemQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME+" WHERE " + PHANLOAI +" = ?",new String[] {"Ly thuyet"} );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setCau_hoi(c.getString(c.getColumnIndex(CAUHOI)));
                question.setPhan_loai(c.getString(c.getColumnIndex(PHANLOAI)));
                question.setSo_cau_tra_loi(c.getString(c.getColumnIndex(SOCAUTRALOI)));
                question.setCau_A(c.getString(c.getColumnIndex(TRALOIA)));
                question.setCau_B(c.getString(c.getColumnIndex(TRALOIB)));
                question.setCau_C(c.getString(c.getColumnIndex(TRALOIC)));
                question.setCau_D(c.getString(c.getColumnIndex(TRALOID)));
                question.setDap_an_1(c.getString(c.getColumnIndex(DAPAN1)));
                question.setDap_an_2(c.getString(c.getColumnIndex(DAPAN2)));
                question.setImage(c.getInt(c.getColumnIndex(IMAGE)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getBienBaoQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME+" WHERE " + PHANLOAI +" = ?",new String[] {"Bien bao"} );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setCau_hoi(c.getString(c.getColumnIndex(CAUHOI)));
                question.setPhan_loai(c.getString(c.getColumnIndex(PHANLOAI)));
                question.setSo_cau_tra_loi(c.getString(c.getColumnIndex(SOCAUTRALOI)));
                question.setCau_A(c.getString(c.getColumnIndex(TRALOIA)));
                question.setCau_B(c.getString(c.getColumnIndex(TRALOIB)));
                question.setCau_C(c.getString(c.getColumnIndex(TRALOIC)));
                question.setCau_D(c.getString(c.getColumnIndex(TRALOID)));
                question.setDap_an_1(c.getString(c.getColumnIndex(DAPAN1)));
                question.setDap_an_2(c.getString(c.getColumnIndex(DAPAN2)));
                question.setImage(c.getInt(c.getColumnIndex(IMAGE)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getSaHinhQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME+" WHERE " + PHANLOAI +" = ?",new String[] {"Sa hinh"} );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setCau_hoi(c.getString(c.getColumnIndex(CAUHOI)));
                question.setPhan_loai(c.getString(c.getColumnIndex(PHANLOAI)));
                question.setSo_cau_tra_loi(c.getString(c.getColumnIndex(SOCAUTRALOI)));
                question.setCau_A(c.getString(c.getColumnIndex(TRALOIA)));
                question.setCau_B(c.getString(c.getColumnIndex(TRALOIB)));
                question.setCau_C(c.getString(c.getColumnIndex(TRALOIC)));
                question.setCau_D(c.getString(c.getColumnIndex(TRALOID)));
                question.setDap_an_1(c.getString(c.getColumnIndex(DAPAN1)));
                question.setDap_an_2(c.getString(c.getColumnIndex(DAPAN2)));
                question.setImage(c.getInt(c.getColumnIndex(IMAGE)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
