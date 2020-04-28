package cn.magikarpll.smsemailclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyImage {

    private byte[] srcImage;

    private byte[] markImage;

    private int locationX;

    private int locationY;

}
