package com.ydb.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ydb.bean.ResultBean;
import com.ydb.dao.IAlbumDao;
import com.ydb.entity.Album;
import com.ydb.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AlbumServiceImp implements IAlbumService {

    @Autowired
    private IAlbumDao mapper;

    ResultBean resultBean;

    @Override
    public ResultBean<Album> addAlbum(Album album) {
        resultBean = new ResultBean<Album>();
        album.setAlbumCreatetime(new Date());
        int code = mapper.insertAlbum(album);
        if (code == 1) {
            //插入数据成功
            resultBean.setStatus(ResultBean.SUCCSSED_CODE);
            resultBean.setMsg("添加相册成功");
            resultBean.setData(Arrays.asList(album));
        } else {
            resultBean.setStatus(ResultBean.FAILURE_CODE);
            resultBean.setMsg("添加相册失败");
        }
        return resultBean;
    }

    @Override
    public ResultBean<Album> dropAlbum(Integer album_id) {
        resultBean = new ResultBean<Album>();
        int code = mapper.deleteAlbum(album_id);
        if (code == 1) {
            resultBean.setStatus(ResultBean.SUCCSSED_CODE);
            resultBean.setMsg("删除成功");
        } else {
            resultBean.setStatus(ResultBean.FAILURE_CODE);
            resultBean.setMsg("删除失败");
        }
        return resultBean;
    }

    @Override
    public ResultBean<Album> updateAlbum(Album album) {
        resultBean = new ResultBean<Album>();
        int code = mapper.updateAlbum(album);
        resultBean.setData(Arrays.asList(album));
        if (code == 1) {
            resultBean.setStatus(ResultBean.SUCCSSED_CODE);
            resultBean.setMsg("修改相册成功");
            resultBean.setData(Arrays.asList(album));
        } else {
            resultBean.setStatus(ResultBean.FAILURE_CODE);
            resultBean.setMsg("修改相册失败");
        }
        return resultBean;
    }

    @Override
    public ResultBean<Album> queryAlbum(Integer album_id) {
        Album album = mapper.selectAlbumById(album_id);
        resultBean = new ResultBean<Album>();
        resultBean.setStatus(ResultBean.SUCCSSED_CODE);
        resultBean.setMsg("查询相册成功");
        resultBean.setData(Arrays.asList(album));
        return resultBean;
    }

    @Override
    public ResultBean<Album> queryAlbum(String album_name) {
        Album album = mapper.selectAlbumByName(album_name);
        resultBean = new ResultBean<Album>();
        resultBean.setStatus(ResultBean.SUCCSSED_CODE);
        resultBean.setMsg("查询相册成功");
        resultBean.setData(Arrays.asList(album));
        return resultBean;
    }

    @Override
    public ResultBean<List<Album>> queryAlbum(Integer pageSize, Integer pageNub) {
        PageHelper.startPage(pageNub, pageSize);
        Page<Album> page = mapper.selectAllAlbum();
        resultBean = new ResultBean<Album>();
        resultBean.setStatus(ResultBean.SUCCSSED_CODE);
        resultBean.setMsg("查询相册成功");
        resultBean.setData(page.getResult());
        return resultBean;
    }

    @Override
    public ResultBean<List<Album>> queryAlbum() {
        List<Album> albums = mapper.selectAllAlbum();
        resultBean = new ResultBean<Album>();
        resultBean.setStatus(ResultBean.SUCCSSED_CODE);
        resultBean.setMsg("查询相册成功");
        resultBean.setData(albums);
        return resultBean;
    }
}
