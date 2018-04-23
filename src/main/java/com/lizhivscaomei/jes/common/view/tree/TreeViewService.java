package com.lizhivscaomei.jes.common.view.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhi on 2018/4/23.
 */
public abstract class TreeViewService<T> {
    private String rootId = "-1";//根节点标志
    private List<TreeVo> treeVoList;//所有节点

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public List<TreeVo> getTreeVoList() {
        return treeVoList;
    }

    public void setTreeVoList(List<T> tList) {
        treeVoList=new ArrayList<TreeVo>();
        for(T t:tList){
            treeVoList.add(this.convertDTO(t));
        }
    }
    public abstract TreeVo convertDTO(T t);
    /**
     * 获取树的根节点
     *
     * @return 一棵树的根节点
     */
    public TreeVo getRoot() {
        return this.getTreeNodeAT(rootId);
    }

    /**
     * 根据节点ID获取一个节点
     *
     * @param id 节点ID
     * @return 对应的节点对象
     */
    public TreeVo getTreeNodeAT(String id) {
        for (TreeVo treeNode : treeVoList) {
            if (treeNode.getId() == id)
                return treeNode;
        }
        return null;
    }

    /**
     * 将节点数组归并为一棵树（填充节点的children域）
     * 时间复杂度为O(n^2)
     *
     * @return
     */
    public TreeVo convertToTree() {
        for (TreeVo treeNode : treeVoList) {
            if (!treeNode.getPid().equals(rootId)) {
                TreeVo t = this.getTreeNodeAT(treeNode.getPid());
                t.getNodes().add(treeNode);
            }
        }
        return this.getRoot();
    }
}
