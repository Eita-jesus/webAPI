# webAPI
## Projeto inicial para desenvolvimento de uma WebAPI



O projeto WEB API é uma criação de um servidor web. Este projeto faz parte do curso de Full Stack e serve como uma introdução ao servidor web. Vale ressaltar que no meu GitHub, você encontrará outros projetos relacionados, incluindo o front end e o desenvolvimento mobile, que fazem parte do curso de Full Stack, bem como programação em Java do Senac.

Gostaria de expressar meus agradecimentos ao professor Rafael Ramos pelo incrível conteúdo e também ao mentor do Senac (Guthierry).

Agora, vamos direto ao ponto.

Neste projeto, utilizei o Maven 4.0.0, e fiz o download em <https://start.spring.io/>. Além disso, usei o IntelliJ Community como ambiente de desenvolvimento.

Para baixar o projeto e começar a executá-lo, basta acessar <https://github.com/Eita-jesus/webAPI>. Para isso, acesse o seu GitHub no diretório onde deseja salvar o projeto e digite "git clone <https://github.com/Eita-jesus/webAPI>". Isso fará o download do projeto.

Em seguida, você precisa baixar o Maven 4.0.0 para a sua máquina. Você pode fazer o download em <https://maven.apache.org/download.cgi>. Se estiver utilizando Windows, recomenda-se usar o formato ZIP Archives, enquanto se estiver usando macOS ou Linux, o formato Tar.gz Archives é ideal.

Agora, você precisa configurar o Maven:

No Windows, abra o Painel de Controle, vá para Sistema e Segurança > Sistema > Configurações avançadas do sistema. Clique em "Variáveis de ambiente" e adicione uma nova variável de sistema chamada M2_HOME, com o valor sendo o caminho para o diretório onde você extraiu o Maven. Em seguida, edite a variável de sistema Path e adicione "%M2_HOME%\bin" no final do valor. Isso adicionará o Maven ao PATH.

No Linux/macOS, edite o arquivo ~/.bashrc ou ~/.bash_profile (ou equivalente) no seu editor de texto favorito e adicione as seguintes linhas:

bash
Copy code
~~~ CMD \ Pront de comando
export M2_HOME=/caminho/para/o/diretório/do/Maven
export PATH=$PATH:$M2_HOME/bin
~~~
Após fazer isso, abra o IntelliJ e, no terminal, execute "mvn clean install". Se ocorrer algum aviso ao tentar executar o projeto, é possível que seja devido ao uso de algumas bibliotecas JSON. Caso receba um aviso de que não foi possível localizar essas bibliotecas no IntelliJ, vá até a pasta \webAPI\lib e clique com o botão direito sobre o arquivo "json-20230618.jar" para importar a biblioteca. Após isso, basta executar o programa (MAIN)principal.
