package org.seckill.dto;

/**
 * 暴露秒杀dto
 */
public class Exposer {
    private boolean exposed;
    private String md5;
    private Long sekillId;
    protected Long now;
    private Long start;
    private Long end;

    public Exposer(boolean exposed, Long sekillId, String md5) {
        this.exposed = exposed;
        this.sekillId = sekillId;
        this.md5 = md5;
    }

    public Exposer(boolean exposed, Long sekillId, Long now, Long start, Long end) {
        this.exposed = exposed;
        this.sekillId = sekillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, Long sekillId) {
        this.exposed = exposed;
        this.sekillId = sekillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSekillId() {
        return sekillId;
    }

    public void setSekillId(Long sekillId) {
        this.sekillId = sekillId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", sekillId=" + sekillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
