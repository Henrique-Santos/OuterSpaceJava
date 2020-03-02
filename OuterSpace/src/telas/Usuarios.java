package telas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Usuarios {
    String nome, senha;
    
    //LOGIN
    public boolean login(String usuarioD, String senhaD){
        String dir = System.getProperty("user.dir");
        String linha="";
        try {
            FileReader arq = new FileReader(dir+"/usuarios.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            //ler a linha e armazenar na variavel
            while((linha = lerArq.readLine())!=null){  
                System.out.println(linha);
                String credenciais[] = linha.split("_%_");
                System.out.println("Usuario : " + credenciais[1] + " Senha: " + credenciais[2]);
                if(credenciais[1].equals(usuarioD) && credenciais[2].equals(senhaD)) {
                    System.out.println("Usuario e senha correspondem");
                    return true;
                }
            }
            lerArq.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //CADASTRO
    public boolean cadastrar(String usuarioD, String senhaD, String nomeD){
        String dir = System.getProperty("user.dir");
        String linha;
        
        try{
            if(validacaoCampos(usuarioD, senhaD, nomeD)){
                FileReader arq = new FileReader(dir+"/usuarios.txt");
                BufferedReader lerArq = new BufferedReader(arq);
                //ler a linha 
                while((linha = lerArq.readLine())!=null){
                    String credenciais[] = linha.split("_%_");
                    System.out.println("Usuario: " + credenciais[1]);
                    if(credenciais[1].equals(usuarioD)){
                        return false;
                    }
                }
                arq.close();  
                //armazenar na variavel 
                FileWriter fw = new FileWriter(dir+"/usuarios.txt", true);
                BufferedWriter arquivo = new BufferedWriter(fw);
                arquivo.write(nomeD +"_%_" +usuarioD +"_%_" +senhaD);
                arquivo.newLine();
                arquivo.close();  
                return true;
            }else{
                return false;
            }
        }catch (IOException e){
            e.printStackTrace(); 
            return false;
        }
    }
    
    private boolean validacaoCampos(String usuario, String senha, String nome){
        if((!usuario.equals(""))&&(!senha.equals(""))&&(!nome.equals(""))){
            return true;
        }
        return false;
    }
    
    public static boolean validacaoCadastro (String nome, String usuario){
        String dir = System.getProperty("user.dir");
        String linha;
        try{
            FileReader arq = new FileReader(dir+"/usuarios.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            //ler a linha 
                while((linha = lerArq.readLine())!=null){
                    String credenciais[] = linha.split("_%_");
                    if(credenciais[0].equals(nome)&&(credenciais[1].equals(usuario))){
                        arq.close();
                        return true;
                    }
                }
            arq.close();
            return false;
        }catch (IOException e){
            e.printStackTrace(); 
            return false;
        }
    }
    
    //ESQUECISENHA
    public boolean aterarsenha(String usuariod, String senhad, String nomed){
        String dir = System.getProperty("user.dir");
        String linha;
        String linhaNova = nomed + "_%_" + usuariod + "_%_" + senhad;
        try{
            if(validacaoCampos(usuariod, senhad, nomed)){
                FileReader arq = new FileReader(dir+"/usuarios.txt");
                BufferedReader lerArq = new BufferedReader(arq);
                FileWriter arqTemp = new FileWriter(dir+"/temp_usuarios.txt", true);
                BufferedWriter arqTempW = new BufferedWriter(arqTemp);
                    while((linha = lerArq.readLine()) != null){

                        String credenciais[] = linha.split("_%_");
                        System.out.println("Usuario: " + credenciais[1]);
                        if(!credenciais[1].equals(usuariod)){
                            arqTempW.write(linha);
                            arqTempW.newLine();
                        }else{
                            arqTempW.write(linhaNova);
                            arqTempW.newLine();
                        }
                    }

                    lerArq.close();                
                    arqTempW.close();
                    
                    System.out.println(dir);
                    File arquivoDeletar = new File(dir+"/usuarios.txt");
                    if(arquivoDeletar.delete()){
                      System.out.println("Passou deletar");  
                    }
                    File arquivoRenomear = new File(dir+"/temp_usuarios.txt");
                    if(arquivoRenomear.renameTo(new File(dir+"/usuarios.txt"))){
                    System.out.println("Passou renomear"); 
                }
                return true;
            }else{
                return false; 
            }
        }catch (IOException e){
            e.printStackTrace(); 
            return false;
        }
    }
}
