# Planner

Bem-vindo ao Planner de Tarefas! Este aplicativo foi desenvolvido para ajudar os usuários a organizar e gerenciar suas tarefas de forma eficiente e intuitiva. Abaixo, você encontrará uma visão geral dos conceitos e tecnologias implementados no projeto.


## :movie_camera: Video

<img src="https://github.com/user-attachments/assets/0272d896-3353-4980-bee3-0d9b39165c00" width="250">&emsp;<img src="https://github.com/user-attachments/assets/2c69e3fb-9f5b-4e26-8ae1-262a6a95c1e8" width="250">&emsp;<img src="https://github.com/user-attachments/assets/e38bde20-aed7-4870-b8e5-35f9ee24ac4f" width="250">

## :camera_flash: Screenshots

<img src="https://github.com/user-attachments/assets/ef66cbba-a963-4477-a3df-d629a13884aa" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/b492600f-e2fd-42ac-b619-976849a093df" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/442cbce2-cb5c-4d61-9f7e-f6f4d162ce3f" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/52cbc177-65d9-4d68-8fd1-00db06f6bb2e" width="250">&emsp;


🛠️ Technologies used

Funcionalidades Principais

Criação de Tarefas: Permite adicionar, editar e excluir tarefas.

Persistência de Dados: As informações do usuário são salvas para que sejam mantidas mesmo após fechar o app.

Configurações do Usuário: Personalização de preferências através de opções salvas localmente.

Tecnologias e Conceitos Implementados

1. SharedPreferences

Utilizado para armazenar informações simples e chave-valor, como preferências do usuário (tema, notificações, etc.). É ideal para configurações rápidas que não precisam de estrutura complexa.

2. Preference Screen

Implementado para fornecer uma interface amigável onde o usuário pode configurar suas preferências diretamente no app. Essas configurações são gerenciadas com SharedPreferences.

3. Room

Usado para gerenciar a persistência de dados relacionais. Ele substitui o uso direto de SQLite e oferece uma API mais simples e robusta. No app, o Room é utilizado para:

Salvar, atualizar e excluir tarefas do banco de dados local.

Garantir a consistência dos dados mesmo quando o app é fechado.

4. DataStore

Adotado como uma alternativa mais moderna ao SharedPreferences para armazenar preferências de forma segura e eficiente. O DataStore é baseado em Kotlin Coroutines e Flow, oferecendo:

Leitura e escrita de dados de forma assíncrona.

Melhor desempenho e suporte para manipulação de dados mais complexos.

5. MVVM (Model-View-ViewModel)

Padrão arquitetural implementado para garantir uma separação clara entre lógica de negócio, interface de usuário e gerenciamento de dados. Suas vantagens incluem:

Manutenção mais fácil do código.

Melhora na testabilidade do app.

Uso do ViewModel para lidar com o ciclo de vida das atividades e fragmentos.

6. Injeção de Dependências Pura

Optamos por usar injeção de dependências manual, sem bibliotecas externas como Dagger ou Hilt, para demonstrar controle completo e aprendizado do conceito. Isso inclui:

Fornecimento de dependências através de construtores.

Redução de acoplamento entre componentes.
