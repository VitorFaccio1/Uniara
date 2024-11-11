using HomeEasyApi.Data;
using HomeEasyApi.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace HomeEasyApi.Controllers;

[ApiController]
[Route("[controller]")]
public class AnunciosController : Controller
{
    private readonly HomeEasyApiContext _context;

    public AnunciosController(HomeEasyApiContext context)
    {
        _context = context;
    }

    [HttpGet]
    public async Task<IActionResult> List()
    {
        return Ok(await _context.Anuncio.ToListAsync());
    }

    [HttpPost]
    public async Task<IActionResult> Create([Bind("Id,Titulo,Descricao")] Anuncio anuncio)
    {
        if (ModelState.IsValid)
        {
            _context.Add(anuncio);
            await _context.SaveChangesAsync();
            return Ok(anuncio);
        }

        return BadRequest("Formulário invalido");
    }
}