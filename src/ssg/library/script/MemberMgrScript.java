package ssg.library.script;

import lombok.Getter;

public class MemberMgrScript extends Script{

  StringBuilder sb =new StringBuilder();
  int index = 1;


  @Getter
  private final static MemberMgrScript memberMgrScriptInstance = new MemberMgrScript();


  /** 회원관리 메뉴(관리자) */
  public void printAdminMemberMenu() {
    index =1;
    sb.append("---회원 관리 메뉴---\n").append("\t").append(index++).append(". 회원등록 승인\t").append(index++).append(". 조회\t").
        append(index++).append(". 회원 상세보기\t").append(index++).append(". 회원수정\n").append("\t").append(index++).append(". 회원삭제\t").
        append(index++).append(". 회원권한 수정\t").append(index++).append(". 이전화면\n");
    printString(sb);
    printInputNumber();
  }

  /** 회원관리 메뉴(일반회원) */
  public void printEmplMemberMenu() {
    index =1;
    sb.append("---회원 관리 메뉴---\n").append("\t")
        .append(index++).append(". 회원 상세보기\t").append(index++).append(". 회원수정\t").
        append(index++).append(". 이전화면\n");
    printString(sb);
    printInputNumber();
  }

  /** 회원관리 메뉴(사장) */
  public void printPresMemberMenu() {
    index =1;
    sb.append("---회원 관리 메뉴---\n").append("\t")
        .append(index++).append(". 회원 조회\t").append(index++).append(". 회원 상세보기\t").append(index++).append(". 회원수정\t").
        append(index++).append(". 회원삭제\n").append("\t").append(index++).append(". 이전화면\n");
    printString(sb);
    printInputNumber();
  }
}
