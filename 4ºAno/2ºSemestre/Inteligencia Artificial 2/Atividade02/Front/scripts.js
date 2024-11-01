function uploadFile() {
    const formData = new FormData();
    const fileInput = document.getElementById('fileInput');
    const file = fileInput.files[0];

    if (!file) {
        alert('Por favor, selecione um arquivo para upload.');
        return; 
    }

    formData.append('file', file);

    fetch('https://localhost:7267/api/metadados/upload', {
        method: 'POST',
        body: formData
    })
    .then(async response => {
        if (!response.ok) {
            const err = await response.json();
            throw new Error(err.message || 'Erro ao fazer upload do arquivo.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        displayMetadado(data);
    })
    .catch(error => {
        displayError(error.message);
    });
}

function displayMetadado(metadata) {
    const metadataDisplay = document.getElementById('metadadoDisplay');
    metadataDisplay.innerHTML = `
        <p><strong>ID:</strong> ${metadata.id}</p>
        <p><strong>Data:</strong> ${metadata.data}</p>
        <p><strong>Nome do Arquivo:</strong> ${metadata.nomeArquivo}</p>
        <p><strong>Formato do Arquivo:</strong> ${metadata.formatoArquivo}</p>
        <p><strong>Colunas:</strong> ${metadata.colunas}</p>
    `;
}