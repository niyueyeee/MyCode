import dao.BookDao;
import dao.Impl.BookDaoImpl;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;
import pojo.Book;

import java.io.File;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-20 21:03
 */
public class LuceneFirst {
    @Test
    public void add() throws Exception {
        //1:原始文档  -- Mysql数据
        //2:获取文档  -- Sql 语句   Java工程 jdbc
        BookDao bookDao = new BookDaoImpl();
        //3:查询所有Book结果集
        List<Book> books = bookDao.queryBookList();
        //books.forEach(System.out::println);
        //5:分析文档 (分词)
        IKAnalyzer ikAnalyzer = new IKAnalyzer();
//        StandardAnalyzer analyzer = new StandardAnalyzer();
        //6:创建索引
        //1)指定索引库位置 (磁盘保存 或是内存保存)
        //2)分词器进行分析
        Directory directory = FSDirectory.open(new File("D:\\343"));
        //内存保存索引
        //Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, ikAnalyzer);
        //创建索引的对象
        IndexWriter indexWriter = new IndexWriter(directory, config);
        for (Book book : books) {
            Document doc = new Document();
            //域对象
            //ID
            StringField idField = new StringField("id", String.valueOf(book.getId()), Field.Store.YES);
            //名称
            Field nameField = new TextField("name", book.getName(), Field.Store.YES);
            //价格
            Field priceField = new FloatField("price", book.getPrice(), Field.Store.YES);
            //图片
            Field picField = new StoredField("pic", book.getPic());
            //描述
            Field descField = new TextField("desc", book.getDesc(), Field.Store.NO);
            doc.add(idField);
            doc.add(nameField);
            doc.add(priceField);
            doc.add(picField);
            doc.add(descField);
            //保存数据到索引库
            indexWriter.addDocument(doc);
        }
        //索引库 有事务吗?
        //有
        //indexWriter.commit();
        indexWriter.close();
    }

    //搜索索引
    @Test
    public void testSearch() throws Exception {
        TermQuery query = new TermQuery(new Term("name", "java"));
        FSDirectory directory = FSDirectory.open(new File("D:\\343"));
        DirectoryReader open = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(open);
        TopDocs topDocs = indexSearcher.search(query, 5);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId = scoreDoc.doc;
            Document doc = indexSearcher.doc(docId);
            System.out.println("id:" + doc.get("id"));
            System.out.println("name:" + doc.get("name"));
            System.out.println("price:" + doc.get("price"));
            System.out.println("pic:" + doc.get("pic"));
            System.out.println("desc:" + doc.get("desc"));

        }
    }

    //删除
    @Test
    public void testDelete() throws Exception {
        Analyzer analyzer = new StandardAnalyzer();
        //6:创建索引
        Directory directory = FSDirectory.open(new File("D:\\343"));

        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        //创建索引的对象
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //删除 全部 慎用
        //indexWriter.deleteAll();

        indexWriter.deleteDocuments(new Term("name", "java"));

        indexWriter.close();

    }

    //修改
    @Test
    public void testUpdate() throws Exception {
        Analyzer analyzer = new StandardAnalyzer();
        //6:创建索引
        Directory directory = FSDirectory.open(new File("D:\\343"));

        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        //创建索引的对象
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //Lucene世界里 没有修改  所谓的修改就是删除了 再添加
        Document doc = new Document();

        //域对象
        //ID
        Field idField = new StringField("haha", "hhhh", Field.Store.YES);
        //名称
        Field nameField = new TextField("hoho", "llll", Field.Store.YES);

        doc.add(idField);
        doc.add(nameField);

        indexWriter.updateDocument(new Term("name", "spring"), doc);

        indexWriter.close();
    }
}
