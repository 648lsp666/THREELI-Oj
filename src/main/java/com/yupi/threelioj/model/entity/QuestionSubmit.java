package com.yupi.threelioj.model.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 閻?劍鍩涢幓鎰?唉
 */
@Getter
@Setter
public class QuestionSubmit {
    /**
     * id
     */
    private Long id;

    /**
     * 妫版?娲?id
     */
    private Long questionid;

    /**
     * 閻?劍鍩?id
     */
    private Long userid;

    /**
     * 缂傛牜鈻肩拠顓♀枅
     */
    private String language;

    /**
     * 閻?劍鍩涙禒锝囩垳
     */
    private String code;

    /**
     * 閸掋倝顣芥穱鈩冧紖(json)
     */
    private String judgeinfo;

    /**
     * 閻樿埖锟斤拷 0:瀵板懎鍨芥０锟?1:閸掋倝顣芥稉锟?2:闁?俺绻?3:閺堫亪锟芥俺绻
     */
    private Long status;

    /**
     * 閸掓稑缂撻弮鍫曟？
     */
    private Date createtime;

    /**
     * 閺囧瓨鏌婇弮鍫曟？
     */
    private Date updatetime;
}