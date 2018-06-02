package com.lizhivscaomei.jes.common.view.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhi on 2018/4/23.
 */
public class TreeVo {
    private String id;//标志
    private String pid;//父节点标志
    private String text;//文本
    private String icon;//图标
    private String href;//路径
    private List<TreeVo> nodes=new ArrayList<TreeVo>();//子节点

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<TreeVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeVo> nodes) {
        this.nodes = nodes;
    }
}
